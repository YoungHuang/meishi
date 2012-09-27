package meishi

import org.springframework.dao.DataIntegrityViolationException

class HotAreaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [hotAreaInstanceList: HotArea.list(params), hotAreaInstanceTotal: HotArea.count()]
    }

    def create() {
        [hotAreaInstance: new HotArea(params)]
    }

    def save() {
        def hotAreaInstance = new HotArea(params)
        if (!hotAreaInstance.save(flush: true)) {
            render(view: "create", model: [hotAreaInstance: hotAreaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'hotArea.label', default: 'HotArea'), hotAreaInstance.id])
        redirect(action: "show", id: hotAreaInstance.id)
    }

    def show() {
        def hotAreaInstance = HotArea.get(params.id)
        if (!hotAreaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'hotArea.label', default: 'HotArea'), params.id])
            redirect(action: "list")
            return
        }

        [hotAreaInstance: hotAreaInstance]
    }

    def edit() {
        def hotAreaInstance = HotArea.get(params.id)
        if (!hotAreaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hotArea.label', default: 'HotArea'), params.id])
            redirect(action: "list")
            return
        }

        [hotAreaInstance: hotAreaInstance]
    }

    def update() {
        def hotAreaInstance = HotArea.get(params.id)
        if (!hotAreaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'hotArea.label', default: 'HotArea'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (hotAreaInstance.version > version) {
                hotAreaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'hotArea.label', default: 'HotArea')] as Object[],
                          "Another user has updated this HotArea while you were editing")
                render(view: "edit", model: [hotAreaInstance: hotAreaInstance])
                return
            }
        }

        hotAreaInstance.properties = params

        if (!hotAreaInstance.save(flush: true)) {
            render(view: "edit", model: [hotAreaInstance: hotAreaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'hotArea.label', default: 'HotArea'), hotAreaInstance.id])
        redirect(action: "show", id: hotAreaInstance.id)
    }

    def delete() {
        def hotAreaInstance = HotArea.get(params.id)
        if (!hotAreaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'hotArea.label', default: 'HotArea'), params.id])
            redirect(action: "list")
            return
        }

        try {
            hotAreaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'hotArea.label', default: 'HotArea'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'hotArea.label', default: 'HotArea'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
