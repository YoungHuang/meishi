package meishi

import grails.converters.JSON

import org.springframework.dao.DataIntegrityViolationException

class ShopController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [shopInstanceList: Shop.list(params), shopInstanceTotal: Shop.count()]
    }

    def create() {
        [shopInstance: new Shop(params)]
    }

    def save() {
        def shopInstance = new Shop(params)
        if (!shopInstance.save(flush: true)) {
            render(view: "create", model: [shopInstance: shopInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'shop.label', default: 'Shop'), shopInstance.id])
        redirect(action: "show", id: shopInstance.id)
    }

    def show() {
        def shopInstance = Shop.get(params.id)
        if (!shopInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'shop.label', default: 'Shop'), params.id])
            redirect(action: "list")
            return
        }

        [shopInstance: shopInstance]
    }

    def edit() {
        def shopInstance = Shop.get(params.id)
        if (!shopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'shop.label', default: 'Shop'), params.id])
            redirect(action: "list")
            return
        }

        [shopInstance: shopInstance]
    }

    def update() {
        def shopInstance = Shop.get(params.id)
        if (!shopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'shop.label', default: 'Shop'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (shopInstance.version > version) {
                shopInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'shop.label', default: 'Shop')] as Object[],
                          "Another user has updated this Shop while you were editing")
                render(view: "edit", model: [shopInstance: shopInstance])
                return
            }
        }

        shopInstance.properties = params

        if (!shopInstance.save(flush: true)) {
            render(view: "edit", model: [shopInstance: shopInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'shop.label', default: 'Shop'), shopInstance.id])
        redirect(action: "show", id: shopInstance.id)
    }

    def delete() {
        def shopInstance = Shop.get(params.id)
        if (!shopInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'shop.label', default: 'Shop'), params.id])
            redirect(action: "list")
            return
        }

        try {
            shopInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'shop.label', default: 'Shop'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'shop.label', default: 'Shop'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def image() {
		def input = servletContext.getResourceAsStream("/images/shop/1_310x310.jpg")
		response.outputStream << input
	}
	
	def search() {
		params.max = params.max ? params.int('max') : 10
		def shopList
		if (params.keywords)
			shopList = Shop.findAllByNameLike(params.keywords, [max: params.max, offset: params.offset])
		else
			shopList = Shop.list([max: params.max, offset: params.offset])
		
		render shopList as JSON
	}
}
