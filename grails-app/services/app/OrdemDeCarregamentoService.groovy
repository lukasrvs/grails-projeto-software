package app

import grails.gorm.services.Service

@Service(OrdemDeCarregamento)
interface OrdemDeCarregamentoService {

    OrdemDeCarregamento get(Serializable id)

    List<OrdemDeCarregamento> list(Map args)

    Long count()

    void delete(Serializable id)

    OrdemDeCarregamento save(OrdemDeCarregamento ordemDeCarregamento)

}