package com.unilearning.mapwithcoordinates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceGroup
import android.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Load necessary configuration so as to download the OSM maps.
        //This line sets the user agent, which is a requirement to download the OSM maps.
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_main)
    }
}