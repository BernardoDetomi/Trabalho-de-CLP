package clp.tp.ui

import java.util.Scanner

abstract class MenuAbstrato {
    fun mostrarMenu(scanner: Scanner) {
        var opcao: Int

        do {
            println("\n\n\n")
            mostrarTitulo()
            mostrarOpcoes()
            print("INFORME A SUA OPCAO: ")
            opcao = executarOpcao(scanner.nextInt(), scanner)
        } while (opcao != 0)
    }

    protected abstract fun executarOpcao(opcao: Int, scanner: Scanner): Int
    protected abstract fun mostrarOpcoes()
    protected abstract fun mostrarTitulo()
} 