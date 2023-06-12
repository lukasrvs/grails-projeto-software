package app

import grails.gorm.services.Service

@Service(Motorista)
interface MotoristaService {

    Motorista get(Serializable id)

    List<Motorista> list(Map args)

    Long count()

    void delete(Serializable id)

    Motorista save(Motorista motorista)

}