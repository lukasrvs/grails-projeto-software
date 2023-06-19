package app

class Rotas {
    String origem
    String destino
    int distancia
    
    static constraints = {
        origem nullable: false
        destino nullable: false
        distancia min: 0
    }

    String toString() {
        "Rota Origem: $origem, Destino: $destino"
    }
}
