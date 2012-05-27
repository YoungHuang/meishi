package meishi

import org.springframework.dao.DataIntegrityViolationException

class DishCategoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dishCategoryInstanceList: DishCategory.list(params), dishCategoryInstanceTotal: DishCategory.count()]
    }

    def create() {
        [dishCategoryInstance: new DishCategory(params)]
    }

    def save() {
        def dishCategoryInstance = new DishCategory(params)
        if (!dishCategoryInstance.save(flush: true)) {
            render(view: "create", model: [dishCategoryInstance: dishCategoryInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), dishCategoryInstance.id])
        redirect(action: "show", id: dishCategoryInstance.id)
    }

    def show() {
        def dishCategoryInstance = DishCategory.get(params.id)
        if (!dishCategoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), params.id])
            redirect(action: "list")
            return
        }

        [dishCategoryInstance: dishCategoryInstance]
    }

    def edit() {
        def dishCategoryInstance = DishCategory.get(params.id)
        if (!dishCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), params.id])
            redirect(action: "list")
            return
        }

        [dishCategoryInstance: dishCategoryInstance]
    }

    def update() {
        def dishCategoryInstance = DishCategory.get(params.id)
        if (!dishCategoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (dishCategoryInstance.version > version) {
                dishCategoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'dishCategory.label', default: 'DishCategory')] as Object[],
                          "Another user has updated this DishCategory while you were editing")
                render(view: "edit", model: [dishCategoryInstance: dishCategoryInstance])
                return
            }
        }

        dishCategoryInstance.properties = params

        if (!dishCategoryInstance.save(flush: true)) {
            render(view: "edit", model: [dishCategoryInstance: dishCategoryInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), dishCategoryInstance.id])
        redirect(action: "show", id: dishCategoryInstance.id)
    }

    def delete() {
        def dishCategoryInstance = DishCategory.get(params.id)
        if (!dishCategoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), params.id])
            redirect(action: "list")
            return
        }

        try {
            dishCategoryInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'dishCategory.label', default: 'DishCategory'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
