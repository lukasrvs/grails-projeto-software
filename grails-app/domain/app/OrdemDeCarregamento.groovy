package app

class OrdemDeCarregamento {
    String motorista
    Pedido pedido
    BigDecimal valorCarga
    BigDecimal impostos
    String destinoFinal
    String status
    Rotas rotas

    static constraints = {
        motorista nullable: false
        pedido nullable: false
        valorCarga min: 0.0
        impostos min: 0.0
        destinoFinal nullable: false
        status nullable: false
        rotas nullable: true
    }
}
