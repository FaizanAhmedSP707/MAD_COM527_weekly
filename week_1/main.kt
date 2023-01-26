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
	val car1 = Car("Toyota", "Land Cruiser", 4500, 230, 0)
    val car2 = Car("Lamborghini", "Aventador", 8000, 390, 0)
    println(car1)
	println()
    println(car2)
	println()
    car1.accelerate(20)
    car2.accelerate(50)
    println(car1)
	println()
    println(car2)
	println()
    car1.decelerate(15)
    car2.decelerate(40)
    println(car1)
	println()
    println(car2)

    println("\n\n\n")
    val johann = Employee("Johann Kimmich", "Administrator", 46000.0)
    val halima = Programmer("Halima Khan", "Front-End Developer", 49000.0, "Java", "Improving on company's front end website functions")
    val richardson = Manager("Richardson", "CEO", 107000.0, Car("Mercedes", "G63 Wagon", 6500, 300, 0), 340)

    johann.printDetails()
    println()
    halima.printDetails()
    println()
    richardson.printDetails()
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

open class Employee(var name: String, var jobTitle: String, var salary: Double) {

    open fun printDetails() {
        println("Name: $name, Job Title: $jobTitle, Salary: $salary")
    }
}

class Programmer(n: String, jt : String, s: Double, var favProgLang: String, var currentProject: String) : Employee(n,jt,s) {

    override fun printDetails() {
        super.printDetails()
        println("Favourite Programming Language: $favProgLang, Current Project: $currentProject")
    }
}

class Manager(n: String, jt : String, s: Double, var companyCar: Car, var numOfShares: Int) : Employee(n,jt,s) {

    override fun printDetails() {
        super.printDetails()
        println("Company car: $companyCar \n\n Number of Shares in the company: $numOfShares")
    }
}