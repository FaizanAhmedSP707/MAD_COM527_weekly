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