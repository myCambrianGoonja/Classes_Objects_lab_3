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
class Die {
     var color: Color? = null
    var numberOfSides: Sides? = null
    var sideUp: Int? = null

    constructor() {
        color = Color.values().find { it.otherName == "d6" }
        numberOfSides = Sides.SIX
        roll()
    }

    constructor(numberOfSides: Int) {
        val validNumberOfSides = Sides.values().find { it.value == numberOfSides }
        if(validNumberOfSides != null) {
            this.numberOfSides = validNumberOfSides
            color = Color.values().find { it.otherName == "d${validNumberOfSides}" }
            roll()
        } else {
            println("We have dices with only dices with 3,4,6,20 sides only")
        }
    }

    fun roll() {
        println("Rolling the dice")
        sideUp = Random.nextInt(1, numberOfSides?.value?.plus(1)?: 1)
    }
}