package app

class Pessoa {
    
    String nome
    String email
    String contato
    String telefone
    String cpfCnpj

    String pais
    String estado
    String cidade
    String cep
    String logradouro
    Integer numero

    static constraints = {
        nome(minSize: 2, blank: false, maxSize: 255)
        cpfCnpj(validator: {return ((it.size() == 11 && (new Validacao()).isCPF(it)) || (it.size() == 14 && (new Validacao()).isCNPJ(it)))},matches:"^[0-9]+\$")
        email(nullable:true,matches:'^[0-9a-zA-Z@/.,/_#&*/-]+$', maxSize:255)
        contato(nullable:true, maxSize:255)
        pais(nullable:false, maxSize:255)
        estado(nullable:false, maxSize:255)
        logradouro(nullable:false, maxSize:255)
        numero(nullable:false, maxSize:255)
        cidade(nullable:false, maxSize:255)
    }
}
