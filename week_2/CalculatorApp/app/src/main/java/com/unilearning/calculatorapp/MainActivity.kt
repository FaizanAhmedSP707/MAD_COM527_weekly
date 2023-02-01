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
        //val numTextField1 = find
    }
}