package app

class Cliente extends Pessoa{

    String codigoCliente
    Date dataCadastro
    String preferencias
    String status
    String tipoPessoa

    static constraints = {
        codigoCliente(nullable: false, unique: true)
        dataCadastro(nullable: false)
        preferencias(nullable: true, maxSize: 500)
        status(inList: ["ativo", "inativo"])
        tipoPessoa(inList: ["fisica", "juridica"])
    }
}
