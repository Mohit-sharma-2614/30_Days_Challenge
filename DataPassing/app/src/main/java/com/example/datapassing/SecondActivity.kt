package com.example.datapassing

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("EXTRA_NAME")
        val city = intent.getStringExtra("EXTRA_CITY")
        val setData = findViewById<Button>(R.id.btnSetData)
        val setName = findViewById<TextView>(R.id.tvName)
        val setCity = findViewById<TextView>(R.id.tvCity)
        setData.setOnClickListener(){
            setName.text = name
            setCity.text = city
        }

    }
}