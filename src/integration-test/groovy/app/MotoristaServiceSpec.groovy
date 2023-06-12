package app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MotoristaServiceSpec extends Specification {

    MotoristaService motoristaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Motorista(...).save(flush: true, failOnError: true)
        //new Motorista(...).save(flush: true, failOnError: true)
        //Motorista motorista = new Motorista(...).save(flush: true, failOnError: true)
        //new Motorista(...).save(flush: true, failOnError: true)
        //new Motorista(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //motorista.id
    }

    void "test get"() {
        setupData()

        expect:
        motoristaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Motorista> motoristaList = motoristaService.list(max: 2, offset: 2)

        then:
        motoristaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        motoristaService.count() == 5
    }

    void "test delete"() {
        Long motoristaId = setupData()

        expect:
        motoristaService.count() == 5

        when:
        motoristaService.delete(motoristaId)
        sessionFactory.currentSession.flush()

        then:
        motoristaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Motorista motorista = new Motorista()
        motoristaService.save(motorista)

        then:
        motorista.id != null
    }
}
