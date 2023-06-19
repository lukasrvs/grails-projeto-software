package app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RotasController {

    RotasService rotasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rotasService.list(params), model:[rotasCount: rotasService.count()]
    }

    def show(Long id) {
        respond rotasService.get(id)
    }

    def create() {
        respond new Rotas(params)
    }

    def save(Rotas rotas) {
        if (rotas == null) {
            notFound()
            return
        }

        try {
            rotasService.save(rotas)
        } catch (ValidationException e) {
            respond rotas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rotas.label', default: 'Rotas'), rotas.id])
                redirect rotas
            }
            '*' { respond rotas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rotasService.get(id)
    }

    def update(Rotas rotas) {
        if (rotas == null) {
            notFound()
            return
        }

        try {
            rotasService.save(rotas)
        } catch (ValidationException e) {
            respond rotas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rotas.label', default: 'Rotas'), rotas.id])
                redirect rotas
            }
            '*'{ respond rotas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rotasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rotas.label', default: 'Rotas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rotas.label', default: 'Rotas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
