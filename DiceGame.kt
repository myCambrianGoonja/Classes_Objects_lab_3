package game

fun main() {
    testCases()
}

fun testCases() {
    val die = Die() //numberOfSide = SIX && color = YELLOW && sideUp = any number between 1 to 6
    val die1 = Die(3) //numberOfSide = THREE && color = RED && sideUp = any number between 1 to 3
    val die2 = Die(4) //numberOfSide = FOUR && color = WHITE && sideUp = any number between 1 to 4
    val die3 = Die(5) //ERROR because the number of sides with 5 is not an option
    val die4 = Die(6) // Same as default || die results
    val die5 = Die(20) //numberOfSide = TWENTY && color = ORANGE && sideUp = any number between 1 to 20

    printResults(die, null)
    printResults(die1, 3)
    printResults(die2, 4)
    printResults(die3, 5)
    printResults(die4, 6)
    printResults(die5, 20)
}

fun printResults(die: Die, valuePassed: Int?) {
     //RESULTS OF THE TEST CASES WITH constructor()
    println("FOR: ${valuePassed} Default color of the dice: ${die.color}")
    println("FOR: ${valuePassed} Default numberOfSide of the dice: ${die.numberOfSides}")
    println("FOR: ${valuePassed} And the side currently showing is: ${die.sideUp}")
}