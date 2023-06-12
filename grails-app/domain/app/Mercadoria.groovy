package app

class Mercadoria {

    String nome
    String descricao
    BigDecimal preco
    Integer quantidade
    String codigoBarras
    String categoria
    String fornecedor
    Date dataValidade
    String localizacao
    String imagem
    String marca
    BigDecimal peso
    String dimensoes

    static constraints = {
        nome(nullable: false, blank: false)
        descricao(nullable: true, maxSize: 1000)
        preco(nullable: false, min: 0.01)
        quantidade(nullable: false, min: 0)
        codigoBarras(nullable: true, blank: true)
        categoria(nullable: true, blank: true)
        fornecedor(nullable: true, blank: true)
        dataValidade(nullable: true, validator: { val, obj ->
            return val == null || val >= new Date()
        })
        localizacao(nullable: true, blank: true)
        imagem(nullable: true, blank: true)
        marca(nullable: true, blank: true)
        peso(nullable: true, min: 0.01)
        dimensoes(nullable: true, blank: true)
    }

}
