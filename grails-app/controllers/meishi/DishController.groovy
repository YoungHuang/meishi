package meishi

import org.springframework.dao.DataIntegrityViolationException

class DishController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dishInstanceList: Dish.list(params), dishInstanceTotal: Dish.count()]
    }

    def create() {
        [dishInstance: new Dish(params)]
    }

    def save() {
        def dishInstance = new Dish(params)
        if (!dishInstance.save(flush: true)) {
            render(view: "create", model: [dishInstance: dishInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'dish.label', default: 'Dish'), dishInstance.id])
        redirect(action: "show", id: dishInstance.id)
    }

    def show() {
        def dishInstance = Dish.get(params.id)
        if (!dishInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])
            redirect(action: "list")
            return
        }

        [dishInstance: dishInstance]
    }

    def edit() {
        def dishInstance = Dish.get(params.id)
        if (!dishInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])
            redirect(action: "list")
            return
        }

        [dishInstance: dishInstance]
    }

    def update() {
        def dishInstance = Dish.get(params.id)
        if (!dishInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (dishInstance.version > version) {
                dishInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'dish.label', default: 'Dish')] as Object[],
                          "Another user has updated this Dish while you were editing")
                render(view: "edit", model: [dishInstance: dishInstance])
                return
            }
        }

        dishInstance.properties = params

        if (!dishInstance.save(flush: true)) {
            render(view: "edit", model: [dishInstance: dishInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'dish.label', default: 'Dish'), dishInstance.id])
        redirect(action: "show", id: dishInstance.id)
    }

    def delete() {
        def dishInstance = Dish.get(params.id)
        if (!dishInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])
            redirect(action: "list")
            return
        }

        try {
            dishInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
