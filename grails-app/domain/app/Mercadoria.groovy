package app

class Mercadoria {

    String nome
    String descricao
    BigDecimal preco
    Integer quantidade
    String codigoBarras
    String fornecedor
    String localizacao
    String marca
    BigDecimal peso
    String dimensoes

    static constraints = {
        nome(nullable: false, blank: false)
        descricao(nullable: true, maxSize: 1000)
        preco(nullable: false, min: 0.01)
        quantidade(nullable: true, min: 0)
        codigoBarras(nullable: true, blank: true)
        fornecedor(nullable: true, blank: true)
        localizacao(nullable: true, blank: true)
        marca(nullable: true, blank: true)
        peso(nullable: true, min: 0.01)
        dimensoes(nullable: true, blank: true)
    }

    String toString() {
        "$nome "
    }

}
