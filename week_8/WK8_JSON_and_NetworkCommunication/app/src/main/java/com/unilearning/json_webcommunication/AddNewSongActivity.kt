package com.unilearning.json_webcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button

import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import android.widget.Toast

class AddNewSongActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addsong)
    }
}