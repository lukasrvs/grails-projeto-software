package app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MercadoriaController {

    MercadoriaService mercadoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mercadoriaService.list(params), model:[mercadoriaCount: mercadoriaService.count()]
    }

    def show(Long id) {
        respond mercadoriaService.get(id)
    }

    def create() {
        respond new Mercadoria(params)
    }

    def save(Mercadoria mercadoria) {
        if (mercadoria == null) {
            notFound()
            return
        }

        try {
            mercadoriaService.save(mercadoria)
        } catch (ValidationException e) {
            respond mercadoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mercadoria.label', default: 'Mercadoria'), mercadoria.id])
                redirect mercadoria
            }
            '*' { respond mercadoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mercadoriaService.get(id)
    }

    def update(Mercadoria mercadoria) {
        if (mercadoria == null) {
            notFound()
            return
        }

        try {
            mercadoriaService.save(mercadoria)
        } catch (ValidationException e) {
            respond mercadoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mercadoria.label', default: 'Mercadoria'), mercadoria.id])
                redirect mercadoria
            }
            '*'{ respond mercadoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mercadoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mercadoria.label', default: 'Mercadoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mercadoria.label', default: 'Mercadoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
