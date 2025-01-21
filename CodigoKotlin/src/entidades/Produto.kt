package clp.tp.entidades

class Produto : Entidade {
    var nome: String
    var valor: Double

    constructor() : super() {
        nome = ""
        valor = 0.0
    }

    constructor(nome: String, valor: Double) : super() {
        this.nome = nome
        this.valor = valor
    }

    override fun toString(): String = "${super.toString()}Nome: $nome\tValor: %.2f".format(valor)
} 