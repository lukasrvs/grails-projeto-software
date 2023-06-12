package app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MotoristaController {

    MotoristaService motoristaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond motoristaService.list(params), model:[motoristaCount: motoristaService.count()]
    }

    def show(Long id) {
        respond motoristaService.get(id)
    }

    def create() {
        respond new Motorista(params)
    }

    def save(Motorista motorista) {
        if (motorista == null) {
            notFound()
            return
        }

        try {
            motoristaService.save(motorista)
        } catch (ValidationException e) {
            respond motorista.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'motorista.label', default: 'Motorista'), motorista.id])
                redirect motorista
            }
            '*' { respond motorista, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond motoristaService.get(id)
    }

    def update(Motorista motorista) {
        if (motorista == null) {
            notFound()
            return
        }

        try {
            motoristaService.save(motorista)
        } catch (ValidationException e) {
            respond motorista.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'motorista.label', default: 'Motorista'), motorista.id])
                redirect motorista
            }
            '*'{ respond motorista, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        motoristaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'motorista.label', default: 'Motorista'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'motorista.label', default: 'Motorista'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
