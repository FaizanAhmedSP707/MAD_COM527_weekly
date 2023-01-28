//This Kotlin file is written to take note of all code snippets that were shown during WEEK 1

fun main(args: Array<String>) {
    //All program code goes here!
    println("* Topic below: Variables example\n")

    // Declare a as an Int. "val" means it is immutable (cannot be changed)
    val a: Int = 3

    // Type inference: "b" is an Int because it is initialised to an Int
    val b = 4
    
    // "c" is a "var", which means it can be changed
    var c = 5    

    // increase "c" by one
    c++

    // this would give a compiler error as "b" is immutable
    // b++

    // this would also give a compiler error as "c" is implicitly an Int
    //c = "A String"

    // Some other data types
    val d = 12345678L // Long
    val pi = 3.141592654 // Double
    val f = 1.23f // Float
    val str = "Hello" // String


    // Print them out. Note how we can embed variables in a string
    // by preceding them with '$'
    println("a is $a, b is $b, c is $c, d is $d, f is $f, pi is $pi, str is $str")

    println("\n *Next topic below: Loops in Kotlin\n")

    /* ---> LOOPS IN KOTLIN <-- */
    // Count from 1 to 10
    for (i in 1..10) {
        println(i)
    }

    // Count from 1 to 9 ("until" discounts 10 itself)
    for(j in 1 until 10) {
        println(j)
    }

    // count from 1 to 9 in steps of 2
    for(k in 1..9 step 2) {
        println(k)
    }

    println("\n *Next topic below: Conditional statements in Kotlin\n")

    /* ---> CONDITIONAL STATEMENTS IN KOTLIN <--- */
    println("Enter your name:")
    val n = readLine()
    if (n == "Linus Torvalds") {
        println("You invented Linux")
    } else {
        println("You didn't invent Linux")
    }

    println("Enter your grade:")
    val grade = readLine()
    when(grade) {
        "A" -> println("First")
        "B" -> println("2.1")
        "C" -> println("2.2")
        "D" -> println("Third")
        "F" -> { println("Fail")
                println("Please resit in the summer.") }
        else -> println("Invalid grade $grade.")
    }

    println("\n *Next topic below: Conditional expressions\n")

    /* ---> CONDITIONAL EXPRESSIONS <--- */
    println("Enter your name:")
    val n = readLine()

    // "msg" contains the result of the if statement
    val msg = if (n=="Linus Torvalds") "You invented Linux" else "You didn't invent Linux"
    println(msg)

    println("Enter your grade:")
    val grade = readLine()

    // "degree" contains the result of the when statement
    val degree = when(grade) {
        "A" -> "First" // Return "First" when grade is "A"
        "B" -> "2.1" // Return "2.1" when grade is "B"
        "C" -> "2.2"
        "D" -> "Third"
        "F" -> "Fail"
        else -> "Invalid grade $grade."
    }
    println("Degree awarded: $degree.")

    println("\n *Next topic below: Basic arrays, including for-in and if-in\n")

    /* ---> Basic arrays, including for-in and if-in <--- */
    val langs = arrayOf("Python", "Java", "JavaScript", "PHP", "Kotlin")
    println("Languages you are learning at university:")
    for(curLang in langs) {
        println(curLang)
    }
    println("Please enter a programming language:")
    val lang = readLine()
    val msg = if(lang in langs) "learning" else "not learning"
    println("You are $msg $lang at university.")

    println("\n *Next topic below: Non-nullable variables\n")

    /* ---> NON-NULLABLE VARIABLES <--- */
    var s: String = null
    println(s.length);

    println("\n *Next topic below: Nullable variables\n")

    /* ---> NULLABLE VARIABLES <--- */
    var s: String? = null
    println(s.length);

    println("\n *Next topic below: The safe-access operator\n")

    /* ---> THE SAFE_ACCESS OPERATOR <--- */
    var s: String? = null
    println(s?.length);

    println("\n *Next topic below: A practical example, and introducing Elvis\n")

    /* ---> A practical example, and introducing Elvis <--- */
    println("Please enter a number:")
    val str1 = readLine() // this might return null

    // Elvis: Set a EITHER to the return value of toInt(), or 0 if str1 is null
    val a = str1?.toInt() ?: 0

    println("Please enter another number:")
    val str2 = readLine() // this might return null

    // Elvis: Set b EITHER to the return value of toInt(), or 0 if str2 is null
    val b = str2?.toInt() ?: 0

    // Note how we can embed full expressions inside strings with $
    println("The sum of the two numbers is ${a+b}");

    println("\n *Next topic below: Functions in Kotlin (See commented out code instead!)\n")

    /* ---> FUNCTIONS IN KOTLIN <--- */
    /*
    CODE NEEDS TO BE COMMENTED FOR OBVIOUS REASONS

    fun printString(s: String, nTimes: Int)
        for(i in 1..nTimes) {
            print(s)
        }
        print("\n")
    }

    fun cube(number: Double) : Double {
        return number * number * number
    }

    fun main (args: Array<String>) {
        printString("*", 3)    
        printString("#", 4)    
        printString("!", 5)    
        println("The cube of 3 is: ${cube(3.0)}")
    }
    */

    println("\n *Next topic below: Classes and Objects in Kotlin (See commented out code instead!\n")

    /* ---> Classes and Objects in Kotlin <--- */
    /*
    CODE WAS COMMENTED OUT FOR OBVIOUS REASONS

    class Cat (n: String, a: Int, w: Int) {

        // Attributes
        val name: String
        var age: Int
        var weight: Int
    
        // Init block, for performing tasks on creation of the object, in other words: a constructor
        init {
            name = n
            age = a
            weight = w
        }

        fun walk() {
            this.weight--
        }

        fun display() {
            println("Name: $name Age: $age Weight: $weight")
        }
    }

    fun main (args: Array<String>) {
        val felix = Cat("Felix", 10, 10)
        val tom = Cat("Tom", 5, 5)
        felix.walk()
        tom.walk()
        felix.display()
        tom.display()
    }
    */

    println("\n *Next topic below: Making our class more concise - automatically setting constructor parameters equal to class attributes\n")

    /* ---> Making our class more concise - automatically setting constructor parameters equal to class attributes <--- */
    /*
    CODE WAS COMMENTED OUT FOR OBVIOUS REASONS

    class Cat (val name: String, var age: Int, var weight: Int) {

        fun walk() {
            this.weight--
        }

        fun display() {
            println("Name: $name Age: $age Weight: $weight")
        }
    }


    fun main (args: Array<String>) {
        val felix = Cat("Felix", 10, 10)
        val tom = Cat("Tom", 5, 5)
        felix.walk()
        tom.walk()
        felix.display()
        tom.display()
    }
    */

    println("\m *Next topic below: Data classes - concisely representing complex data structures\n")

    /* ---> Data classes - concisely representing complex data structures <--- */
    /*
    public class Point {
        public int x, y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    In Kotlin, in an extension of the previous example, you can create a Point class with just one line of code:

    data class Point(val x:Int, val y: Int)

    That is it! This will create a Point class, with a two argument constructor (x and y), and two immutable (because of val) attributes, also x and y
    This could be used in a main() function as follows:

    data class Point(val x:Int, val y: Int)

    fun main (args: Array<String>) {
        val p = Point(0, 5)
        val p2 = Point(5, 2)
        println("${p.x} ${p.y}")
        println("${p2.x} ${p2.y}")
    }
    */
    
}
