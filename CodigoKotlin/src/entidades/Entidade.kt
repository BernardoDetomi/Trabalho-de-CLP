package clp.tp.entidades

abstract class Entidade {
    val id: Long = System.currentTimeMillis()

    override fun toString(): String = "Id: $id\t"
} 