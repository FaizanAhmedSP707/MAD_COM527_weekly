package com.unilearning.week7_roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Coroutines
        // A coroutine is a separate process which runs in the background,
        // independent of the main process

        // Find our add button
        findViewById<Button>(R.id.btnCreate).setOnClickListener {
            // the code 'lifecycleScope.launch' launches a coroutine in the scope of the activity lifecycle
            // (when the activity is destroyed , the coroutine will terminate
            //  as the activity is its' parent)
            lifecycleScope.launch {
                // Read in the artist, title and year from the UI
                val title = findViewById<EditText>(R.id.etTitle).text.toString()
                val artist = findViewById<EditText>(R.id.etArtist).text.toString()
                val year = findViewById<EditText>(R.id.etYear).text.toString().toInt()

                // Switch to the background context to do the query
                withContext(Dispatchers.IO) {

                }
            }
        }

        findViewById<Button>(R.id.btnSearch).setOnClickListener {

        }

        findViewById<Button>(R.id.btnCreate).setOnClickListener {

        }

        findViewById<Button>(R.id.btnCreate).setOnClickListener {

        }

    }
}