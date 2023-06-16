package game

import kotlin.random.Random

/*
    Enum for the list of colors to help
    with different values of color

    @param other = we have to able to
    assign the color value using the numberOfSides
    we can do that using Color.other

    @pram hexCode = an extra feature where
    the user can set the value of a color using
    hexCode of a color

    thus user can set the value of a color by
    1. color.name
    2. color.other
    3. color.hexCode
*/
enum class Color(val other: String, val hexCode: String) {
    RED("d3", "#FF0000"),
    WHITE("d4", "#FFFFFF"),
    YELLOW("d6", "#FFFF00"),
    ORANGE("d20", "#FFA500")
}

/*
   For the number of sides in a dice
   user can set the value using the
   numeric vale or spell the same value

   @param value = takes a numeric value
   and sets the alphabetic enum accordingly

   hence different properties of Sides are:
   1. Sides.name: String
   2. Sides.value: Int

*/
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
    // Setting up all the values to be null in start
    private var color: Color? = null
    private var numberOfSides: Sides? = null
    var sideUp: Int? = null

    // Zero parameter constructor has color d6 and number of sides 6
    constructor() {
        /*
        Color.values() loops through all the values of
        Color enum and .finds the value whos others value
        is 'd6' and sets that as the color value
        */
        color = Color.values().find { it.other == "d6" }
        numberOfSides = Sides.SIX
        roll()
    }

    // Setting the value of numberOfSides and color is based on the numberOfSides
    constructor(numberOfSides: Int) {
        /*
            Sides.values() loops through all the values of
            Sides enum and .finds the value whos 'value' =  numberOfSides
            and sets that as the validNumberOfSides
        */
        val validNumberOfSides = Sides.values().find { it.value == numberOfSides }
        /*
           if the user enters value 21 or the number of value
           that is not set in the Sides enum class then the value
           stored in validNumberOfSides will be null thus
           validNumberOfSides? = meaning if it exists then
           colorName will be d{validNumberOfSides}
        */

        val colorName = validNumberOfSides?.let { "d${it.value}" }

        //  This is a null varification of validNumberOfSides
        if (validNumberOfSides != null) {
            this.numberOfSides = validNumberOfSides
            /*
                Color values are looped and then the one that
                matches colorName is set to the color value
            */
            color = Color.values().find { it.other == colorName }
            roll()
        } else {
            // Guiding the user to enter the right values for the number of sides
            println("We have dices with only dices with 3,4,6,20 sides only")
            return
        }
    }
    /*
       Constructor helps assigning dynamic values to both color and number of sides

       @param numOfSides = setting the numer of sides
       @param selectedColor = setting the color can be hexCode or 'd6'/'d4' etc or 'RED'
    */
    constructor(numOfSides: Int, selectedColor: String) {
        val validNumberOfSides = Sides.values().find { it.value == numOfSides }
        // Checking whether a name or other or a hexcode is passed which ever matches is choosen
        val validColor =
            Color.values().find { it.name == selectedColor }
                ?: Color.values().find { it.other == selectedColor }
                    ?: Color.values().find { it.hexCode == selectedColor }
        // Null varification of validNumberOfSides and validColor and then assigning values
        if (validColor != null && validNumberOfSides != null) {
            numberOfSides = validNumberOfSides
            color = validColor
            roll()
        } else {
            println("Please enter valid values, values allowed for Colors are")
            // Guiding the user to use the right values for colors
            val allColors = Color.values()
            for (color in allColors) {
                println("Color: ${color.name}, Other: ${color.other}, Hex Code: ${color.hexCode}")
                return
            }
        }
    }
    // Getter for color private parameter
    fun getColor(): String? {
        return color?.name
    }

    // Getter for numberOfSides private parameter
    fun getNumberOfSides(): Int? {
        return numberOfSides?.value
    }

    // Method that sets sideUp into a random number that is <= numberOfSides
    fun roll() {
        sideUp = Random.nextInt(1, numberOfSides?.value?.plus(1) ?: 1)
    }
}
