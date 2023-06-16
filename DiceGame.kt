package game


enum class NumOfParamers(val meaning:String){
    ZEROP("Zero parameters"),
    ONEP("One Parameter")
}

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
    
    val die6 = Die(20, "#FFFFFF") //numberOfSides = TWENTY && color = WHITE && sideUp = any number between 1 to 20
    val die7 = Die(3, "RED") //numberOfSides = THREE && color = RED && sideUp = any number between 1 to 3
    val die8 = Die(4, "GREEN") // Error invlid entry

    printResults(die, null, NumOfParamers.ZEROP.name) // ZERO PARAMETER
   
    printResults(die1, 3, NumOfParamers.ONEP.name) //ONE PARAMETER
    printResults(die2, 4, NumOfParamers.ONEP.name) //ONE PARAMETER
    printResults(die3, 5, NumOfParamers.ONEP.name) //ONE PARAMETER
    printResults(die4, 6, NumOfParamers.ONEP.name) //ONE PARAMETER
    printResults(die5, 20, NumOfParamers.ONEP.name) //ONE PARAMETER
   
    printResults(die6, 20, "#FFA500")
    printResults(die7, 3, "RED")
    printResults(die8, 4, "GREEN")


}

fun printResults(die: Die, valuePassed: Int?, colorPassed: String?) {
     //RESULTS OF THE TEST CASES WITH constructor()
    println()
    if(colorPassed == NumOfParamers.ONEP.name || colorPassed == NumOfParamers.ZEROP.name) {
        var currentParameter = NumOfParamers.values().find { it.name == colorPassed}
        println("Number of parameters for this are: ${currentParameter?.meaning}")
        println()
    } 
    println("FOR: ${valuePassed} && ${colorPassed} Default color of the dice: ${die.color}")
    println("FOR: ${valuePassed} && ${colorPassed} Default numberOfSide of the dice: ${die.numberOfSides}")
    println("FOR: ${valuePassed} && ${colorPassed} the side currently showing is: ${die.sideUp}")

    println()
    println()
    println()
}