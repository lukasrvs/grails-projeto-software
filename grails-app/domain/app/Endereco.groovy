package app

class Endereco {
    String cep
    String cidade
    String pais
    String bairro
    Integer numero
    String complemento

    static constraints = {
        cep(blank:false, cep:true, maxSize:8, matches:'^[0-9]{8}$')
        cidade(nullable:false)
        bairro(nullable:false, validator: { data, obj, errors ->
            if(data != null && data.size() > 255){
                errors.rejectValue('bairro', "default.invalid.max.size.message", ["Bairro","", data, "255"] as Object[], "O campo ultrapassa o tamanho máximo permitido")
            }
        })
        endereco(nullable:false, validator: { data, obj, errors ->
            if(data != null && data.size() > 255){
                errors.rejectValue('endereco', "default.invalid.max.size.message", ["Endereco","", data, "255"] as Object[], "O campo ultrapassa o tamanho máximo permitido")
            }
        })
        tipo(nullable:false);
        complemento(nullable:true, validator: { data, obj, errors ->
            if(data != null && data.size() > 255){
                errors.rejectValue('complemento', "default.invalid.max.size.message", ["Complemento","", data, "255"] as Object[], "O campo ultrapassa o tamanho máximo permitido")
            }
        })
        numero(nullable:false);
    }
}
