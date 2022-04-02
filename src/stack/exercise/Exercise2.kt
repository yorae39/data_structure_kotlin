package src.stack.exercise

import src.stack.api.StackImpl

fun main() {
    println("h((e))llo(world)()".checkParentheses())
    println("h(ello world".checkParentheses())
}

fun String.checkParentheses(): Boolean {
    val stack = StackImpl<Char>()
    for (character in this) {
        when(character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}

fun String.checkParentheses2(): Boolean {
    var countA = 0
    var countB = 0
    for (character in this) {
        when (character) {
            '(' -> countA++
            ')' -> countB++
        }
    }
    return countA == countB
}

fun String.checkParentheses3(): Boolean {
    val stackA = StackImpl<Char>()
    val stackB = StackImpl<Char>()
    for (character in this) {
        when (character) {
            '(' -> stackA.push(character)
            ')' -> stackB.push(character)
        }
    }
    return stackA.count == stackB.count
}