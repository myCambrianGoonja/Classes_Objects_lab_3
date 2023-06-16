package game

fun main() {
    val die = Die()

    println("Default color of the dice: ${die.color}")
    println("Default numberOfSide of the dice: ${die.numberOfSides}")
    println("And the side currently showing is: ${die.sideUp}")
}