package clp.tp.ui

import java.util.Scanner

abstract class MenuEntidade : MenuAbstrato() {
    protected abstract fun listar()
    protected abstract fun adicionar(scanner: Scanner)
    protected abstract fun remover(scanner: Scanner)

    override fun executarOpcao(opcao: Int, scanner: Scanner): Int {
        when (opcao) {
            0 -> return 0
            1 -> listar()
            2 -> adicionar(scanner)
            3 -> remover(scanner)
            else -> System.err.println("OPCAO INVALIDA\n")
        }
        return 1
    }

    override fun mostrarOpcoes() {
        println("""
            0 -> VOLTAR
            1 -> LISTAR
            2 -> ADICIONAR
            3 -> REMOVER
        """.trimIndent())
    }
} 