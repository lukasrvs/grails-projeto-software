package app

import grails.gorm.services.Service

@Service(Rotas)
interface RotasService {

    Rotas get(Serializable id)

    List<Rotas> list(Map args)

    Long count()

    void delete(Serializable id)

    Rotas save(Rotas rotas)

}