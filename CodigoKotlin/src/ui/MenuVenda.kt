package clp.tp.ui

import clp.tp.entidades.Venda
import clp.tp.entidades.Produto
import java.util.Scanner
import clp.tp.data.DAOProduto
import clp.tp.data.DAOVenda

class MenuVenda : MenuEntidade() {
    private val daoVenda = DAOVenda.getInstance() // Declaração de variáveis -> imutável
    private val daoProduto = DAOProduto.getInstance()

    override fun mostrarTitulo() {
        println("MENU VENDAS")
    }

    override fun listar() {
        println(daoVenda.toString())
    }

    override fun adicionar(scanner: Scanner) {
        val venda = Venda()
        
        while (true) {
            var produto: Produto? = null  // mutável e nullable
            var qtd = 0  // Sistema de Tipos -> tipo inferido automaticamente

            while (true) {
                try {
                    println("\nDigite o nome do produto: ")
                    produto = daoProduto.buscar(scanner.next())

                    print("Digite a quantidade: ")
                    qtd = scanner.nextInt()

                    if (produto == null || qtd <= 0) {
                        throw Exception("\nFavor informar os dados corretamente.\n")
                    } else {
                        break
                    }
                } catch (ex: Exception) {
                    System.err.println(ex.message)
                }
            }

            produto?.let { venda.adicionarItem(it, qtd) }

            print("\nDeseja adicionar outro produto à venda (1-SIM/0-NAO)? ")
            if (scanner.nextInt() != 1) break
        }

        println("\n\nNOTA FISCAL\n${venda}")
        daoVenda.adicionar(venda)
    }

    override fun remover(scanner: Scanner) {
        var id: Long = 0

        while (true) {
            try {
                print("\nDigite o id: ")
                id = scanner.nextLong()

                if (id <= 0L) {
                    throw Exception("\nFavor informar os dados corretamente.\n")
                } else {
                    break
                }
            } catch (ex: Exception) {
                System.err.println(ex.message)
            }
        }
        daoVenda.remover(id)
    }
} 