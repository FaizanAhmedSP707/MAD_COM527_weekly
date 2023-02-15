package com.unilearning.geolocation_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import android.location.LocationManager
import android.location.LocationListener
import android.location.Location
import android.content.Context
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Load necessary configuration so as to download the OSM maps.
        //This line sets the user agent, which is a requirement to download the OSM maps.
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        setContentView(R.layout.activity_main)

        val map1 = findViewById<MapView>(R.id.MapDisplay)
        map1.controller.setZoom(14.0)
        map1.controller.setCenter(GeoPoint(0.00, 0.00))

        /* Now we need to check for what permissions have been granted!*/
    }
}