package app

import grails.gorm.services.Service

@Service(Mercadoria)
interface MercadoriaService {

    Mercadoria get(Serializable id)

    List<Mercadoria> list(Map args)

    Long count()

    void delete(Serializable id)

    Mercadoria save(Mercadoria mercadoria)

}