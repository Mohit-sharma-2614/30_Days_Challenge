package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btPress = findViewById<Button>(R.id.btPress)
        val tvCounter = findViewById<TextView>(R.id.tvCounter)

        var count: Int = 0

        btPress.setOnClickListener(){
            count++
            if(count > 10){
                tvCounter.text = "Congrates You have much time for time pass"
            }
            if(count > 19){
                tvCounter.text = "You are still here and cliked for $count Times"
            }
            else {
                tvCounter.text = "You Clicked $count Times"
            }
        }

    }
}