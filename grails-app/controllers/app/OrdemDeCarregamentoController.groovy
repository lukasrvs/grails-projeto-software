package app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrdemDeCarregamentoController {

    OrdemDeCarregamentoService ordemDeCarregamentoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ordemDeCarregamentoService.list(params), model:[ordemDeCarregamentoCount: ordemDeCarregamentoService.count()]
    }

    def show(Long id) {
        respond ordemDeCarregamentoService.get(id)
    }

    def create() {
        respond new OrdemDeCarregamento(params)
    }

    def save(OrdemDeCarregamento ordemDeCarregamento) {
        if (ordemDeCarregamento == null) {
            notFound()
            return
        }

        try {
            ordemDeCarregamentoService.save(ordemDeCarregamento)
        } catch (ValidationException e) {
            respond ordemDeCarregamento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ordemDeCarregamento.label', default: 'OrdemDeCarregamento'), ordemDeCarregamento.id])
                redirect ordemDeCarregamento
            }
            '*' { respond ordemDeCarregamento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ordemDeCarregamentoService.get(id)
    }

    def update(OrdemDeCarregamento ordemDeCarregamento) {
        if (ordemDeCarregamento == null) {
            notFound()
            return
        }

        try {
            ordemDeCarregamentoService.save(ordemDeCarregamento)
        } catch (ValidationException e) {
            respond ordemDeCarregamento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ordemDeCarregamento.label', default: 'OrdemDeCarregamento'), ordemDeCarregamento.id])
                redirect ordemDeCarregamento
            }
            '*'{ respond ordemDeCarregamento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ordemDeCarregamentoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ordemDeCarregamento.label', default: 'OrdemDeCarregamento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ordemDeCarregamento.label', default: 'OrdemDeCarregamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
