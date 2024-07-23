package com.example.midtermq1

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

        var flag: String = "Add";
        val spinnerVal: Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("Add", "Subtract", "Multiply", "Divide")

        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        resBtn.setOnClickListener{ view ->

            val num1Text: EditText = findViewById(R.id.num1Text)
            val num2Text: EditText = findViewById(R.id.num2Text)

            var num1: Double = num1Text.text.toString().toDouble();
            var num2:Double = num2Text.text.toString().toDouble();


            var temp: Double = num1;

            when(flag){
                "Add" -> temp += num2
                "Subtract" -> temp -= num2
                "Multiply" -> temp *= num2
                "Divide" -> temp /= num2
            }

            resText.text = String.format(Locale.US,"%.4f", temp);
        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }
}