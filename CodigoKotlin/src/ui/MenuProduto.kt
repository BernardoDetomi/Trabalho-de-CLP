package clp.tp.ui

import clp.tp.entidades.Produto
import java.util.Scanner
import clp.tp.data.DAOProduto

class MenuProduto : MenuEntidade() {
    private val dao = DAOProduto.getInstance()

    override fun mostrarTitulo() {
        println("MENU PRODUTOS")
    }

    override fun listar() {
        println(dao.toString())
    }

    override fun adicionar(scanner: Scanner) {
        var nome: String? = null
        var valor = 0.0

        while (true) {
            try {
                print("\nDigite o nome: ")
                nome = scanner.next()

                print("Digite o valor: ")
                valor = scanner.nextDouble()

                if (nome.isNullOrEmpty() || valor <= 0.0) {   // Estruturas de controle de fluxo
                    throw Exception("\nFavor informar os dados corretamente.\n")
                } else {
                    break
                }
            } catch (ex: Exception) {
                System.err.println(ex.message)
            }
        }

        dao.adicionar(Produto(nome!!, valor))
    }

    override fun remover(scanner: Scanner) {
        var nome: String? = null

        while (true) {
            try {
                print("\nDigite o nome: ")
                nome = scanner.next()

                if (nome.isNullOrEmpty()) {
                    throw Exception("\nFavor informar o nome corretamente.\n")
                } else {
                    break
                }
            } catch (ex: Exception) {
                System.err.println(ex.message)
            }
        }

        dao.remover(nome!!)
    }
} 