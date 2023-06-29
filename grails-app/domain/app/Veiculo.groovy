package app

class Veiculo {
    String placa
    String marca
    String modelo
    String cor
    String tipo
    Integer ano
    BigDecimal capacidadeTon
    static constraints = {
        placa(unique:true,nullable:false, matches: "[a-z,A-Z][a-z,A-Z][a-z,A-Z]-[a-z,A-Z,0-9][a-z,A-Z,0-9][a-z,A-Z,0-9][a-z,A-Z,0-9]", maxSize:8);
        marca(nullable:true,maxSize:20);
        modelo(nullable:true,maxSize:20);
        cor(nullable:true,maxSize:20);
        tipo(nullable:true,inList:["Cavalo", "Carreta"]);
    }

    String toString() {
        "$placa | $tipo "
    }
}
