package game

import kotlin.random.Random

enum class Color(val otherName: String) {
    RED("d3"),
    WHITE("d4"),
    YELLOW("d6"),
    ORANGE("d20")
}

enum class Sides(val value: Int) {
    THREE(3),
    FOUR(4),
    SIX(6),
    TWENTY(20)
}

/*
    The class Die can be used as a constructor 
    but if we do in our case the compiler gets 
    confused with which constructor should be 
    primary constructor. 
    Thus I am following the treditional 
    technique of creating 3 over ridden 
    constructors with seperate parameters 

 */
class Die() {
     var color: Color? = null
    var numberOfSides: Sides? = null
    var sideUp: Int = 0

    constructor() {
        color = Color.values().find { it.otherName == "d6" }
        numberOfSides = Sides.SIX
        roll()
    }

    constructor(numberOfSides: Int) {
        this.numberOfSides = Sides.values().find { it.value == numberOfSides }
            ?: throw IllegalArgumentException("Invalid number of sides: $numberOfSides")
        roll()
    }

    fun roll() {
        println("Rolling the dice")
        sideUp = Random.nextInt(1, numberOfSides.value + 1)
    }
}