package com.unilearning.mappingwithbuttons_menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts

import android.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {
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

                    // Extract the opentopomap status (true or false) from the intent
                    // and set the map style accordingly
                    val opentopomap = this.getBooleanExtra("com.menudemo.opentopomap", false)
                    val mapAccess = findViewById<MapView>(R.id.map1)

                    // Now set the tile source for the map by checking the returned boolean value
                    mapAccess.setTileSource( if(opentopomap) TileSourceFactory.OpenTopo else TileSourceFactory.MAPNIK )
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_main)
        val map1 = findViewById<MapView>(R.id.map1)
        map1.controller.setZoom(14.0)
        map1.controller.setCenter(GeoPoint(51.05, -1.4))
    }
}