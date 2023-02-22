package com.menudemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts

import android.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // This is to inflate the menu (Which is basically loading the menu as Kotlin objects into memory
    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        // In Java we would need to use the getter method called 'getMenuInflater()'
        // In Kotlin, we can use the property access called 'menuInflater' instead.
        // Refer to the notes from week 2, which covers some aspects of Kotlin properties
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // Handle the menu choices
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.choosemap -> {
                // Launch the secondary activity

                // Create the intent
                val intent = Intent(this, MapChooseActivity::class.java)

                // Create the launcher
                val mapChooseLauncher =
                    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                        /*if (it.resultCode == RESULT_OK) {
                            it.data?.apply {
                                val opentopomap = this.getBooleanExtra("")
                            }
                        }*/
                        val returnIntent: Intent? = it.data
                        if (it.resultCode == RESULT_OK) {
                            returnIntent?.apply {
                                // "this" refers to returnIntent and it will NOT be null
                            }
                        }
                    }

                return true
            }
        }
        return false
    }
}