package clp.tp.data

import clp.tp.entidades.Produto

class DAOProduto private constructor() {
    companion object {
        private val instance = DAOProduto()
        private val dao = DAO<Produto>()

        fun getInstance(): DAOProduto = instance
    }

    fun adicionar(produto: Produto) {
        dao.adicionar(produto)
    }

    fun buscar(id: Long): Produto? = dao.buscar(id)

    fun buscar(nome: String): Produto? {
        return dao.dados.find { it.nome == nome }
    }

    fun remover(id: Long) {
        dao.remover(id)
    }

    fun remover(nome: String) {
        dao.dados.removeIf { it.nome == nome }
    }

    override fun toString(): String = dao.toString()
} 