package com.unilearning.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Main program code below
        val btn1 = findViewById<Button>(R.id.addBtn)
        val btn2 = findViewById<Button>(R.id.subtractBtn)
        val btn3 = findViewById<Button>(R.id.multiplyBtn)
        val btn4 = findViewById<Button>(R.id.divideBtn)
        val numTextField1 = findViewById<EditText>(R.id.numfield1)
        val numTextField2 = findViewById<EditText>(R.id.numfield2)
        val textViewAnswer = findViewById<TextView>(R.id.tvAnswer)

        btn1.setOnClickListener {
            if (numTextField1.text.toString().trim() == ""){
                numTextField1.error = "This field cannot be empty!"
            } else if(numTextField2.text.toString().trim() == ""){
                numTextField2.error = "This field cannot be empty!"
            }
            else {
                val number1 = numTextField1.text.toString().toDouble()
                val number2 = numTextField2.text.toString().toDouble()
                val addAnswer = number1 + number2
                textViewAnswer.text = "Your two numbers added together gives: $addAnswer"
            }
        }

        btn2.setOnClickListener {
            if (numTextField1.text.toString().trim() == ""){
                numTextField1.error = "This field cannot be empty!"
            } else if(numTextField2.text.toString().trim() == ""){
                numTextField2.error = "This field cannot be empty!"
            }
            else {
                val number1 = numTextField1.text.toString().toDouble()
                val number2 = numTextField2.text.toString().toDouble()
                val subtractAnswer = number1 - number2
                textViewAnswer.text ="Your two numbers subtracted gives: $subtractAnswer"
            }
        }

        btn3.setOnClickListener {
            if (numTextField1.text.toString().trim() == ""){
                numTextField1.error = "This field cannot be empty!"
            } else if(numTextField2.text.toString().trim() == ""){
                numTextField2.error = "This field cannot be empty!"
            }
            else {
                val number1 = numTextField1.text.toString().toDouble()
                val number2 = numTextField2.text.toString().toDouble()
                val multiplyAnswer = number1 * number2
                textViewAnswer.text = "Your two numbers multiplied together gives: $multiplyAnswer"
            }
        }

        btn4.setOnClickListener {
            if (numTextField1.text.toString().trim() == ""){
                numTextField1.error = "This field cannot be empty!"
            } else if(numTextField2.text.toString().trim() == ""){
                numTextField2.error = "This field cannot be empty!"
            }
            else {
                val number1 = numTextField1.text.toString().toDouble()
                val number2 = numTextField2.text.toString().toDouble()
                val divisionAnswer = number1 / number2
                textViewAnswer.text = "Your two numbers divided together give: $divisionAnswer"
            }
        }
    }
}