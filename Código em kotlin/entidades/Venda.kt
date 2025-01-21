package clp.tp.entidades

import java.time.LocalDateTime

class Venda : Entidade(), Totalizavel {
    private val dataHora: LocalDateTime = LocalDateTime.now()
    private val itens: MutableList<ItemVenda> = ArrayList()

    fun adicionarItem(produto: Produto, qtd: Int) {
        itens.add(ItemVenda(produto, qtd))
    }

    fun removerItem(posicao: Int) {
        itens.removeAt(posicao)
    }

    fun removerItem(nomeProduto: String) {
        itens.removeIf { it.produto.nome.equals(nomeProduto, ignoreCase = true) }
    }

    override fun toString(): String {
        val sb = StringBuilder("${super.toString()}Data-Hora: $dataHora\nItens:\n")
        itens.forEach { sb.append("\n  $it") }
        sb.append("\nTOTAL: ${total()}")
        return sb.toString()
    }

    override fun total(): Double = itens.sumOf { it.valor * it.qtd }

    private inner class ItemVenda(
        val produto: Produto,
        val qtd: Int
    ) {
        val valor: Double = produto.valor

        override fun toString(): String = 
            String.format("%15s %8.2f x %5d = %8.2f", produto.nome, valor, qtd, valor * qtd)
    }
} 