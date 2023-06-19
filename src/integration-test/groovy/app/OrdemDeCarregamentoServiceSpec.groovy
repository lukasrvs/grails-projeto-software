package app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrdemDeCarregamentoServiceSpec extends Specification {

    OrdemDeCarregamentoService ordemDeCarregamentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OrdemDeCarregamento(...).save(flush: true, failOnError: true)
        //new OrdemDeCarregamento(...).save(flush: true, failOnError: true)
        //OrdemDeCarregamento ordemDeCarregamento = new OrdemDeCarregamento(...).save(flush: true, failOnError: true)
        //new OrdemDeCarregamento(...).save(flush: true, failOnError: true)
        //new OrdemDeCarregamento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ordemDeCarregamento.id
    }

    void "test get"() {
        setupData()

        expect:
        ordemDeCarregamentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OrdemDeCarregamento> ordemDeCarregamentoList = ordemDeCarregamentoService.list(max: 2, offset: 2)

        then:
        ordemDeCarregamentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ordemDeCarregamentoService.count() == 5
    }

    void "test delete"() {
        Long ordemDeCarregamentoId = setupData()

        expect:
        ordemDeCarregamentoService.count() == 5

        when:
        ordemDeCarregamentoService.delete(ordemDeCarregamentoId)
        sessionFactory.currentSession.flush()

        then:
        ordemDeCarregamentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OrdemDeCarregamento ordemDeCarregamento = new OrdemDeCarregamento()
        ordemDeCarregamentoService.save(ordemDeCarregamento)

        then:
        ordemDeCarregamento.id != null
    }
}
