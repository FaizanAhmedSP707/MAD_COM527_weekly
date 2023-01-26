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