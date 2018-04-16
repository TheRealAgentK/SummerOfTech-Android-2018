package ventegocreative.co.nz.sot.commands

interface Command<T> {
    fun execute(): T
}