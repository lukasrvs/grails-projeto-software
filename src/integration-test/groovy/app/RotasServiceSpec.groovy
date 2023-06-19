package app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RotasServiceSpec extends Specification {

    RotasService rotasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rotas(...).save(flush: true, failOnError: true)
        //new Rotas(...).save(flush: true, failOnError: true)
        //Rotas rotas = new Rotas(...).save(flush: true, failOnError: true)
        //new Rotas(...).save(flush: true, failOnError: true)
        //new Rotas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rotas.id
    }

    void "test get"() {
        setupData()

        expect:
        rotasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rotas> rotasList = rotasService.list(max: 2, offset: 2)

        then:
        rotasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rotasService.count() == 5
    }

    void "test delete"() {
        Long rotasId = setupData()

        expect:
        rotasService.count() == 5

        when:
        rotasService.delete(rotasId)
        sessionFactory.currentSession.flush()

        then:
        rotasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rotas rotas = new Rotas()
        rotasService.save(rotas)

        then:
        rotas.id != null
    }
}
