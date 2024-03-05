package com.example.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rgGroup = findViewById<RadioGroup>(R.id.rgGroup)
        val rbSalad = findViewById<RadioButton>(R.id.rbSalad)
        val tvSaved = findViewById<TextView>(R.id.tvSaved)
        val cbMeonis = findViewById<CheckBox>(R.id.cbMeonis)
        val cbWofels = findViewById<CheckBox>(R.id.cbWofels)
          val btSubmit = findViewById<Button>(R.id.btSubmit)

        btSubmit.setOnClickListener(){
            val rbButtonStatus = rgGroup.checkedRadioButtonId
            val meet = findViewById<RadioButton>(rbButtonStatus)
            val meonis = cbMeonis.isChecked
            val wofels = cbWofels.isChecked

            val output = "You orders Burger with : \n"+
                    "${meet.text}\n"+
                    (if(meonis) "Meonis \n" else "")+
                    (if(wofels) "Wofels \n" else "")

            tvSaved.text = output
        }
    }
}