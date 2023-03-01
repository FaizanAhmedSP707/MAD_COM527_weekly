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
            if(latitudeText?.text.toString().trim() == "") {
                latitudeText.error = "This field shouldn't be empty!"
            } else if(longitudeText.text.toString().trim() == "") {
                longitudeText?.error = "This field shouldn't be empty!"
            } else {
                val latCoord = latitudeText.text.toString().toDouble()
                val longCoord = longitudeText.text.toString().toDouble()

                // Now call the function that will send back the relevant data gathered
                sendBackMapValues(latCoord, longCoord)
            }
        }
    }

    fun sendBackMapValues(lat_val: Double, long_val: Double) {
        val intent = Intent()
        val bundle = bundleOf("com.unilearning.mappingwithbuttons_menus.latitude" to lat_val,
                                    "com.unilearning.mappingwithbuttons_menus.longitude" to long_val)
        intent.putExtras(bundle)
        setResult(RESULT_OK, intent)
        finish()
    }
}