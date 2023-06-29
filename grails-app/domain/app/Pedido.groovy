package app

class Pedido {
    Integer id
    Empresa empresaResponsavel
    Mercadoria mercadoria
    Cliente remetente
    Cliente destinatario
    String tomadorServico
    Date dataPedido
    Date dataEntrega
    String status

    static constraints = {
        empresaResponsavel(nullable: false)
        mercadoria(nullable: false)
        remetente(nullable: false)
        destinatario(nullable: false)
        tomadorServico(nullable: false, inList: ['remetente', 'destinatario'])
        status(nullable: false, inList: ['ativo', 'inativo'])
        dataEntrega(validator: { data, obj, erros-> 
            if(data < obj.dataPedido){
                errors.rejectValue('cpfCnpj', "pedido.dataEntrega.validator.invalid")
            }
        })
    }

    String toString() {
        "$id | $remetente | $destinatario | $status"
    }
}
