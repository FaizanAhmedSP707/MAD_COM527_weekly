package com.unilearning.mapping_improvementapp

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_main)
        val map1 = findViewById<MapView>(R.id.map1)
        map1.controller.setZoom(14.0)
        map1.controller.setCenter(GeoPoint(51.05, -0.72))
    }
    fun checkPermissions() {
        //Check to see if the necessary permission has been granted or not.
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED) {
            // TODO --> Add the function that opens the map in the app
            requestLocation()
        } else {
            // If the permissions haven't been granted, request them from the user
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                0)
        }
    }

    /*
    This method runs as soon as the user has either granted or denied the requested permission(s).
    */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            0 -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // TODO --> Add the function that opens the map in the app
                    requestLocation()
                } else {
                    AlertDialog.Builder(this).setPositiveButton("OK", null).
                    setMessage("App will not be able to update the map efficiently.").show()
                }
            }
        }
    }
}