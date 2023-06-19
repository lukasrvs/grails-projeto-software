package app

class BootStrap {

    def init = { servletContext ->
    }
    def destroy = {
    }


    def initMercadorias(){
        // Mercadoria 1
        def mercadoria1 = new Mercadoria(
            nome: "Minério de Ferro",
            descricao: "Minério de ferro para produção de aço",
            preco: 100.0,
            quantidade: 50,
            codigoBarras: "MIF123",
            fornecedor: "Mineradora A",
            localizacao: "Depósito 1",
            marca: "N/A",
            peso: 100.0,
            dimensoes: "N/A"
        )
        mercadoria1.save()

        // Mercadoria 2
        def mercadoria2 = new Mercadoria(
            nome: "Carvão Mineral",
            descricao: "Carvão mineral para geração de energia",
            preco: 50.0,
            quantidade: 80,
            codigoBarras: "CM987",
            fornecedor: "Mineradora B",
            localizacao: "Depósito 2",
            marca: "N/A",
            peso: 50.0,
            dimensoes: "N/A"
        )
        mercadoria2.save()

        // Mercadoria 3
        def mercadoria3 = new Mercadoria(
            nome: "Ouro em Barra",
            descricao: "Barras de ouro purificado",
            preco: 1000.0,
            quantidade: 10,
            codigoBarras: "OB555",
            fornecedor: "Mineradora C",
            localizacao: "Depósito 3",
            marca: "N/A",
            peso: 1.0,
            dimensoes: "N/A"
        )
        mercadoria3.save()

        // Mercadoria 4
        def mercadoria4 = new Mercadoria(
            nome: "Cobre em Lingotes",
            descricao: "Lingotes de cobre para indústria",
            preco: 500.0,
            quantidade: 20,
            codigoBarras: "CL789",
            fornecedor: "Mineradora D",
            localizacao: "Depósito 4",
            marca: "N/A",
            peso: 50.0,
            dimensoes: "N/A"
        )
        mercadoria4.save()

        // Mercadoria 5
        def mercadoria5 = new Mercadoria(
            nome: "Diamante em Bruto",
            descricao: "Diamantes brutos para lapidação",
            preco: 2000.0,
            quantidade: 5,
            codigoBarras: "DB246",
            fornecedor: "Mineradora E",
            localizacao: "Depósito 5",
            marca: "N/A",
            peso: 0.5,
            dimensoes: "N/A"
        )
        mercadoria5.save()
    }
}
