package com.unilearning.week7_roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = HittasticDatabase.getDatabase(application)
        // Coroutines
        // A coroutine is a separate process which runs in the background,
        // independent of the main process

        val etTitle = findViewById<EditText>(R.id.etTitle)
        // Find our add button
        findViewById<Button>(R.id.btnCreate).setOnClickListener {
            // the code 'lifecycleScope.launch' launches a coroutine in the scope of the activity lifecycle
            // (when the activity is destroyed , the coroutine will terminate
            //  as the activity is its' parent)
            lifecycleScope.launch {
                // Read in the artist, title and year from the UI
                val id = findViewById<EditText>(R.id.etId)
                val title = etTitle.text.toString()
                val artist = findViewById<EditText>(R.id.etArtist).text.toString()
                val year = findViewById<EditText>(R.id.etYear).text.toString().toInt()
                val song = Song(0, title, artist, year)

                // Declare a variable to hold the ID allocated to the new record (this is for
                var insertID = 0L

                // Switch to the background context to do the query
                withContext(Dispatchers.IO) {
                    insertID = db.songDao().addSong(song)
                }

                // Update the ID edit text to contain the insertID
                id.setText("$insertID")
            }
        }

        findViewById<Button>(R.id.btnSearch).setOnClickListener {
            lifecycleScope.launch {
                val id = findViewById<EditText>(R.id.etId).text.toString().toLong()

                val setartist = findViewById<EditText>(R.id.etArtist)
                val setyear = findViewById<EditText>(R.id.etYear)
                var returnSong : Song? = null

                withContext(Dispatchers.IO) {
                    returnSong = db.songDao().getSongById(id)
                }
                returnSong?.apply {
                    etTitle.setText(this.title)
                    setartist.setText(this.artist)
                    setyear.setText("${this.year}") //Causes an error if using 'this.year' --> find out why
                }
            }
        }

        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            lifecycleScope.launch {
                val id = findViewById<EditText>(R.id.etId).text.toString().toLong()
                val titleCHNG = findViewById<EditText>(R.id.etTitle).text.toString()
                val artistCHNG = findViewById<EditText>(R.id.etArtist).text.toString()
                val yearCHNG = findViewById<EditText>(R.id.etYear).text.toString().toInt()
                val songIn = Song(id, titleCHNG, artistCHNG, yearCHNG)

                var rowsAffected = 0

                withContext(Dispatchers.IO) {
                    rowsAffected = db.songDao().updateSong(songIn)
                }
                if(rowsAffected == 0){
                    Toast.makeText(this@MainActivity, "Song with entered ID doesn't exist!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Update operation successful!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            lifecycleScope.launch {
                val checkid = findViewById<EditText>(R.id.etId).text.toString().toLong()


                //this@MainActivity
                var rowsChanged = 0

                withContext(Dispatchers.IO) {
                    // Create the song object here, then call the appropriate method from the DAO
                    val songobj = Song(checkid, "", "", 0)
                    rowsChanged = db.songDao().deleteSong(songobj)

                }
                // Check the value returned and assigned to the variable above, and output a message if unsuccessful
                if(rowsChanged == 0) {
                    Toast.makeText(this@MainActivity, "Song with entered ID doesn't exist!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Delete operation successful!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}