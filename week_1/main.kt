MAD - Mobile Application Developement COM527
/*
Activity file for the week 1 exercises of the module Mobile Application Development (COM527)
*/

//Question 1 : Doing the Hello World example from the notes
/*
fun main(args: Array<String>) {
	println("Hello World!")
}
*/

fun main(args: Array<String>) {
  //println("Hello world!")
  //answer all questions in this main function

    //question2()
    //question3()
    //question4()
}

fun question2() {
	println("Please enter your name:")
	val userN = readLine()
	println()
	println("How many times do you want to repeat the printing of your name? (Please enter a number):")
	val str1 = readLine()
	val nRepeat = str1?.toInt() ?: 1

	println()
	println("$userN\n".repeat(nRepeat))
}

fun question3() {
	val favSongArtists = arrayOf("Atif Aslam", "Rahat Fateh Ali Khan", "Autopilot", "A Himitsu")

	var userGuess : String?
	//while loop below
	do{
		println("Try to enter an artist's name that exists: ")
		userGuess = readLine()

		if (userGuess in favSongArtists){
			println()
			println("You have successfully guessed the name of your favourite artist!")
		}
	} while(!(userGuess in favSongArtists))
}

fun question4() {
	println("Please enter a numerical percentage to calculate the grade achieved: ")
	
	val markIn = readLine()
	// Converting string input to integer input by using the safety access operator
	val mark = markIn?.toInt() ?: 0
	
	val grade = when(mark) {
		in 70..100 -> "A"
		in 60..69 -> "B"
		in 50..59 -> "C"
		in 40..49 -> "D"
		in 30..39 -> "E"
		in 0..29 -> "F"
		else -> "Error - invalid percentage"
	}
	println("Grade received is $grade.")
}

class Car(val make: String, val model: String, val engineCapacity: Int, val topSpeed: Int, var currentSpeed: Int) {

    //Attributes
    /*
    val make = makeIn
    val model = modelIn
    val engineCapacity = engCapacityIn
    val topSpeed = topSpdIn
    var currentSpeed :Int
    */

    fun accelerate(spdIncreaseBy: Int){
        if(!(currentSpeed == topSpeed)){
            currentSpeed += spdIncreaseBy
        } else {
            currentSpeed = topSpeed
        }
    }

    fun decelerate(spdDecreaseBy: Int){
        if(!(currentSpeed == 0)){
            currentSpeed -= spdDecreaseBy
        } else {
            currentSpeed = 0
        }
    }
    override fun toString(): String {
        return "Make: $make, Model: $model, Engine Capacity in cc: $engineCapacity, Top Speed: $topSpeed, Current Speed: $currentSpeed"
    }
}