package com.unilearning.mappingwithbuttons_menus

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.core.os.bundleOf

class MapCoordinateValues: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_coordinates)

        val latitudeText = findViewById<EditText>(R.id.latitudeField)
        val longitudeText = findViewById<EditText>(R.id.longitudeField)
        val submitBtn = findViewById<Button>(R.id.submitValBtn)

        submitBtn.setOnClickListener {
            /*
            TODO --> Add some error checking on the fields before accessing data, then call the next
                     function to send data back to the main activity
            */
        }
    }
}