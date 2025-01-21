package clp.tp

import java.util.Scanner
import clp.tp.ui.MenuPrincipal

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`).apply {
        useDelimiter("\\R")
    }

    MenuPrincipal().mostrarMenu(scanner)

    scanner.close()
}