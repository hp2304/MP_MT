package com.example.midtermq2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val resBtn: Button = findViewById(R.id.resBtn)
        val resText: TextView = findViewById(R.id.resText)

        val compText: TextView = findViewById(R.id.compText)

        var flag: String = "Rock";
        val spinnerVal: Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("Rock", "Paper", "Scissor")

        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        resBtn.setOnClickListener{ view ->

            val rnds = (0..2).random();
            var compChoice: String;
            if(rnds == 0){
                compChoice = "Rock";
            }
            else if(rnds == 1){
                compChoice = "Paper";
            }
            else{
                compChoice = "Scissor";
            }

            compText.text = compChoice;

            if(flag == "Rock" && compChoice == "Scissor"){
                resText.text = "YOU WON";
            }
            else if(flag == "Paper" && compChoice == "Rock"){
                resText.text = "YOU WON";
            }
            else if(flag == "Scissor" && compChoice == "Paper"){
                resText.text = "YOU WON";
            }
            else if(flag == compChoice){
                resText.text = "DRAW";
            }
            else{
                resText.text = "YOU LOST";
            }
        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                flag = "Rock";
            }
        }

    }
}