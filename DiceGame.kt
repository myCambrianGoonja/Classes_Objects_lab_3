package game

/*
Test case uses parameters with different 
parameters thus using this enum helps optimize the code 
*/
enum class NumOfParamers(val meaning:String){
    ZEROP("Zero parameters"),
    ONEP("One Parameter")
}

fun main() {
    /*
        1.  You can customize the values in the dieTesting 
            by trying different options, such as setting 
            zero parameters or Die(3), Die(5) other variations 
            for the heighestValue() function.
        
        2.  It is better to test one test case at a 
            time because there would otherwise be 
            too much confusion
     */
    var dieTesting = Die(20)
    testingAllTheConstructors()
    diceValueBeforeAndAfter()
    heighestValue(dieTesting) 
    fiveDieUniqueValue()
}

//TESTING ALL THE PARAMETERS 
/*
    Test case 1 
    Create different sized dice using each constructor
 */
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
//This is used to print all the results from testingAllTheConstructors()
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

/*
    Test case 2 
    Roll the dice and display their results (before and after)
 */
fun diceValueBeforeAndAfter() {
    var die: Die = Die()
    println("Default current value of the dice is: ${die.sideUp}")
    die.roll()
    println("Results after you roll is: ${die.sideUp}")
}

/*
    Test case 3
    Choose one Die object and set it to show it's highest value
    we can pass different dies in the dieTesting to check how 
    it works with different values
 */
fun heighestValue(dieTesting: Die) {
    var die: Die = dieTesting
    //The highest values = the max number sides thus the code below
    var heighestValue = die.getNumberOfSides()
    println("The heighest value this dice can have is ${heighestValue}")
}

/*
    Test case 4 
    Create 5 six-sided dice. 
    Roll each Die in a loop until you get 5 of a kind. 
    Count and display the number of rolls.
 */
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
        dice.forEach { 
        it.roll() 
        rolled = rolled + 1 }
        
    }

    println("Dice was rolled $rolled times before all the 5 dice could have a different value")
    println("Dice values are:")
    dice.forEach {
        print("${it.sideUp} ")
    }
}
