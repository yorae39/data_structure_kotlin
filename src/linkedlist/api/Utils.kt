package src.linkedlist.api

infix fun String.example(function: () -> Unit) {
    println("-----Example of $this-----")
    function()
    println()
}