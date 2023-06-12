package app

class Usuario {
    String nome
    String email
    String senha
    Date dataCadastro
    
    static constraints = {
        nome(nullable: false)
        email(nullable: false, email: true, unique: true)
        senha(nullable: false, maxSize: 100)
        dataCadastro(nullable: false)
    }
}
