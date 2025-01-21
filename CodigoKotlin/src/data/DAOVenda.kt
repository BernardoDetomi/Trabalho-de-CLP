package clp.tp.data

import clp.tp.entidades.Venda

class DAOVenda private constructor() {
    companion object {
        private val instance = DAOVenda()
        private val dao = DAO<Venda>()

        fun getInstance(): DAOVenda = instance
    }

    fun adicionar(venda: Venda) {
        dao.adicionar(venda)
    }

    fun buscar(id: Long): Venda? = dao.buscar(id)

    fun remover(id: Long) {
        dao.remover(id)
    }

    override fun toString(): String = dao.toString()
} 