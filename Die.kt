package game
import kotlin.random.Random

enum class Color(val other: String, val hexCode: String) {
    RED("d3", "#FF0000"),
    WHITE("d4", "#FFFFFF"),
    YELLOW("d6", "#FFFF00"),
    ORANGE("d20", "#FFA500")
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
    //Setting up all the values to be null in start
    private var color: Color? = null
    private var numberOfSides: Sides? = null
    var sideUp: Int? = null

    constructor() {
        color = Color.values().find { it.other == "d6" }
        numberOfSides = Sides.SIX
        sideUp = roll()
    }

    constructor(numberOfSides: Int) {
        val validNumberOfSides = Sides.values().find { it.value == numberOfSides }
        val colorName = validNumberOfSides?.let { "d${it.value}" }

        if(validNumberOfSides != null) {
            this.numberOfSides = validNumberOfSides
            color = Color.values().find { it.other == colorName }
            sideUp = roll()
        } else {
            println("We have dices with only dices with 3,4,6,20 sides only")
            return
        }
    }

    constructor(numOfSides:Int, selectedColor: String) {
        val validNumberOfSides = Sides.values().find { it.value == numOfSides }
        val validColor = Color.values().find{ it.name == selectedColor }?: Color.values().find { it.other == selectedColor } ?: Color.values().find { it.hexCode == selectedColor }
        if(validColor != null && validNumberOfSides != null) {
            numberOfSides = validNumberOfSides
            color = validColor
            sideUp = roll()
        } else {
            println("Please enter valid values, values allowed for Colors are")
            val allColors = Color.values()
            for (color in allColors) {
                println("Color: ${color.name}, Other: ${color.other}, Hex Code: ${color.hexCode}")
                return
            }
        }
    }
    //Getter for color private parameter
     fun getColor(): String? {
        return color?.name
    }

    //Getter for numberOfSides private parameter
    fun getNumberOfSides(): Int? {
        return numberOfSides?.value
    }

    fun roll(): Int {
        println("Rolling the dice")
        return Random.nextInt(1, numberOfSides?.value?.plus(1)?: 1)
    }

}