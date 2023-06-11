package app

class Motorista extends Pessoa {
    String cnh
    Date dataNascimento
    String sexo
    static constraints = {
        cpfCnpj(unique: true, validator: {data, obj, errors->
                if (!(new Validacao()).isCPF(data)) {
                    errors.rejectValue('cpfCnpj', "pessoaJuridica.cpfCnpj.validator.invalid1")
                }
                else if ( sgt.Motorista.findByCpfCnpjAndIdNotEqual(data, ((obj.id)?obj.id:0)) != null ) {
                    errors.rejectValue('cpfCnpj', "pessoaJuridica.cpfCnpj.validator.invalid2")
                }
        })
        dataNascimento(blank:false ,max: (new Date()).minus(365*21))
        sexo(nullable:true, inList: ['1', '2'])
    }
}
