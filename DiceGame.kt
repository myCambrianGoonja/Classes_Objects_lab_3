package game


enum class NumOfParamers(val meaning:String){
    ZEROP("Zero parameters"),
    ONEP("One Parameter")
}

fun main() {
    testingAllTheConstructors()
     /*PLEASE UNCOMMENT WHEN TESTING IS NEEDED 
    BECAUSE CHANCES OF THIS GOING INTO INFITE LOOP ARE HIGH */ 
    //fiveDieUniqueValue()
}

//TESTING ALL THE PARAMETERS 
fun testingAllTheConstructors() {

    val die = Die() //numberOfSide = SIX && color = YELLOW && sideUp = any number between 1 to 6
    
    val die1 = Die(3) //numberOfSide = THREE && color = RED && sideUp = any number between 1 to 3
    val die2 = Die(4) //numberOfSide = FOUR && color = WHITE && sideUp = any number between 1 to 4
    val die3 = Die(5) //ERROR because the number of sides with 5 AND all values to be null
    val die4 = Die(6) // Same as default || die results
    val die5 = Die(20) //numberOfSide = TWENTY && color = ORANGE && sideUp = any number between 1 to 20
    
    val die6 = Die(20, "#FFFFFF") //numberOfSides = TWENTY && color = WHITE && sideUp = any number between 1 to 20
    val die7 = Die(3, "RED") //numberOfSides = THREE && color = RED && sideUp = any number between 1 to 3
    val die8 = Die(4, "GREEN") // Error invlid entry AND all values to be null

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
    val color = die.getColor()
    val maxSides = die.getNumberOfSides()
    println()
    if(colorPassed == NumOfParamers.ONEP.name || colorPassed == NumOfParamers.ZEROP.name) {
        var currentParameter = NumOfParamers.values().find { it.name == colorPassed}
        println("Number of parameters for this are: ${currentParameter?.meaning}")
        println()
    } 
    println("FOR: ${valuePassed} && ${colorPassed} Default color of the dice: ${color}")
    println("FOR: ${valuePassed} && ${colorPassed} Default numberOfSide of the dice: ${maxSides}")
    println("FOR: ${valuePassed} && ${colorPassed} the side currently showing is: ${die.sideUp}")

    println()
    println()
    println()
}


/*PLEASE UNCOMMENT THIS WHEN YOU WANT 
TO TEST BECAUSE IT ENDS UP 
GOING IN INFINETE LOOP QUITE OFTEN AS THE 
CHANCES OF 5 Dices having Unique value seems very rare*/
fun fiveDieUniqueValue() {
    //Declared a list of 5 dices
    val dice = List(5) { Die() }
    //rolled = 1 because default executes roll() once
    var rolled = 1
    /*
    Comparing the size of unique list vs without 
    unqiue size to know if there are repeated arrays 
    if not then it keeps rolling till all the dices 
    have unquie value 
    */
    while (dice.map { it.sideUp }.distinct().size != dice.size) {
        dice.forEach { it.roll() }
        rolled++
    }

    println("Dice was rolled $rolled times before all the 5 dice could have a different value")
}
