package app

class Motorista extends Pessoa {
    String cnh
    Date dataNascimento
    String sexo
    static constraints = {
        cpfCnpj(unique: true, validator: {data, obj, errors->
                if (!(new Validacao()).isCPF(data)) {
                    errors.rejectValue('cpfCnpj', "pessoa.cpfCnpj.validator.invalid")
                }
                else if ( app.Motorista.findByCpfCnpjAndIdNotEqual(data, ((obj.id)?obj.id:0)) != null ) {
                    errors.rejectValue('cpfCnpj', "pessoa.cpfCnpj.validator.invalid")
                }
        })
        dataNascimento(blank:false ,max: (new Date()).minus(365*21))
        sexo(nullable:true, inList: ['Feminino', 'Masculino'])
    }
}
