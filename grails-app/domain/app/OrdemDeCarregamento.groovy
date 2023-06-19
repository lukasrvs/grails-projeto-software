package app

class OrdemDeCarregamento {
    Motorista motorista
    Pedido pedido
    BigDecimal valorCarga
    BigDecimal impostos
    String destinoFinal
    String status
    Rotas rotas
    Veiculo veiculoCavalo
    Veiculo veiculoCarreta

    static constraints = {
        motorista(nullable: false)
        pedido(nullable: false)
        valorCarga(min: 0.0)
        impostos(min: 0.0)
        destinoFinal(nullable: false)
        status(nullable: false)
        rotas(nullable: true)
        veiculoCavalo(validator:{data,obj,errors->
            if(data?.tipo == 'carreta'){
                errors.rejectValue('tipo', "veiculo.tipo.validator.invalid")
            }
        })
        veiculoCarreta(validator:{data,obj,errors->
            if(data?.tipo == 'cavalo'){
                errors.rejectValue('tipo', "veiculo.tipo.validator.invalid")
            }
        })
    }
}
