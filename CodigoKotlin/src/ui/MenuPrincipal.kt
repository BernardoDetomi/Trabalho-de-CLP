package clp.tp.ui

import java.util.Scanner

class MenuPrincipal : MenuAbstrato() {
    private val menuProduto = MenuProduto()
    private val menuVenda = MenuVenda()

    override fun executarOpcao(opcao: Int, scanner: Scanner): Int {
        return when (opcao) {
            0 -> 0
            1 -> {
                menuProduto.mostrarMenu(scanner)
                1
            }
            2 -> {
                menuVenda.mostrarMenu(scanner)
                1
            }
            else -> {
                System.err.println("OPCAO INVALIDA\n")
                1
            }
        }
    }

    override fun mostrarOpcoes() {
        println("""
            0 -> FECHAR PROGRAMA
            1 -> PRODUTO
            2 -> VENDA
        """.trimIndent())
    }

    override fun mostrarTitulo() {
        println("MENU PRINCIPAL")
    }
} 