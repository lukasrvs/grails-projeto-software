package app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MercadoriaServiceSpec extends Specification {

    MercadoriaService mercadoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Mercadoria(...).save(flush: true, failOnError: true)
        //new Mercadoria(...).save(flush: true, failOnError: true)
        //Mercadoria mercadoria = new Mercadoria(...).save(flush: true, failOnError: true)
        //new Mercadoria(...).save(flush: true, failOnError: true)
        //new Mercadoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mercadoria.id
    }

    void "test get"() {
        setupData()

        expect:
        mercadoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Mercadoria> mercadoriaList = mercadoriaService.list(max: 2, offset: 2)

        then:
        mercadoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mercadoriaService.count() == 5
    }

    void "test delete"() {
        Long mercadoriaId = setupData()

        expect:
        mercadoriaService.count() == 5

        when:
        mercadoriaService.delete(mercadoriaId)
        sessionFactory.currentSession.flush()

        then:
        mercadoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Mercadoria mercadoria = new Mercadoria()
        mercadoriaService.save(mercadoria)

        then:
        mercadoria.id != null
    }
}
