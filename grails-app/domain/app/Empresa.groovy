package app

class Empresa {
    String nome
    String cnpj
    String endereco
    String telefone
    String email
    String responsavel
    String tipoTransportadora

    static constraints = {
        nome(nullable: false)
        cnpj(nullable: false, unique: true)
        endereco(nullable: false)
        telefone(nullable: false)
        email(nullable: false, email: true)
        responsavel(nullable: false)
        tipo(nullable: false, inList: ["filial", "matriz"])
    }
}
