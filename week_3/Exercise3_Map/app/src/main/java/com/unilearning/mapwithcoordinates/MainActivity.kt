package com.unilearning.mapwithcoordinates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Load necessary configuration so as to download the OSM maps.
        //This line sets the user agent, which is a requirement to download the OSM maps.
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        val latiText = findViewById<TextView>(R.id.textspace1)
        val longiText = findViewById<TextView>(R.id.textspace2)
        val latitudeField = findViewById<EditText>(R.id.latfield)
        val longitudeField = findViewById<EditText>(R.id.lonfield)
        val submitBtn = findViewById<Button>(R.id.coordValsubmit)
        val map1 = findViewById<MapView>(R.id.mapDisplay)

        setContentView(R.layout.activity_main)

        //TODO -> Add the needed button listener that will take input from the EditText fields above
    }
}