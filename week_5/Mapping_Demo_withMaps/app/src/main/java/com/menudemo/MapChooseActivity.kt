package com.menudemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class MapChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_choose)  // Layout for second activity

        // Handling on the second activity to send data back to the first activity
        val regular = findViewById<Button>(R.id.btnRegular)
        regular.setOnClickListener {
            sendBackMapChoice(false)
        }
        val opentopomap = findViewById<Button>(R.id.btnOpenTopoMap)
        opentopomap.setOnClickListener {
            sendBackMapChoice(true)
        }
    }

    fun sendBackMapChoice(opentopo: Boolean) {
        val intent = Intent()
        val bundle = bundleOf("com.menudemo.opentopomap" to opentopo)
        intent.putExtras(bundle)
        setResult(RESULT_OK, intent)
        finish()
    }
}