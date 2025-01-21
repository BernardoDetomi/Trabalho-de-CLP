package clp.tp.data

import clp.tp.entidades.Entidade

class DAO<E : Entidade> {
    val dados: MutableList<E> = ArrayList()

    fun adicionar(entidade: E) {
        dados.add(entidade)
    }

    fun buscar(id: Long): E? {
        return dados.find { it.id == id }
    }

    fun remover(id: Long) {
        dados.removeIf { it.id == id }
    }

    override fun toString(): String {
        return dados.joinToString("\n") { it.toString() }
    }
} 