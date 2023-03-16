package com.unilearning.json_webcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEntry = findViewById<EditText>(R.id.songArtistSearchName)
        val songSearchBtn = findViewById<Button>(R.id.searchSongArtistBtn)
        val resultView = findViewById<TextView>(R.id.webTextDisplay)

        // Button listener that will send requests to the server
        songSearchBtn.setOnClickListener {

            // First attempt to access the value entered in the EditText
            if(nameEntry?.text.toString().trim() == ""){
                // Right now, we want the user to enter some text into this filed before submitting
                Toast.makeText(this, "No name entered in the text field above.", Toast.LENGTH_SHORT).show()
                nameEntry.error = "Artist name field shouldn't be empty."
            } else {
                // The EditText isn't empty, so get the value and then send the request to the server
                val artistName = nameEntry.text.toString()

                val url = "http://10.0.2.2:3000/artist/${artistName}"
                url.httpGet().response { request, response, result ->

                    when(result) {
                        is Result.Success -> {
                            // Parsing not done right now, we'll just be displaying raw data
                            resultView.text = result.get().decodeToString()
                        }

                        is Result.Failure -> {
                            // Failure is when there is an HTTP error
                            resultView.text = "ERROR ${result.error.message}"
                        }
                    }
                }
            }
        }
    }
}