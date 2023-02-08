package com.esprit.diceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import android.util.Patterns.EMAIL_ADDRESS as emailPattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val selectedColors = mutableListOf<Int>()
        var answer = 0
        val red=findViewById<CheckBox>(R.id.red)
        val grp=findViewById<RadioGroup>(R.id.colorsToChoose)
        grp.setOnCheckedChangeListener{ _,id->
            Log.e("test","$id")
        }
        red.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                if(selectedColors.size<2)
                    selectedColors.add(R.color.red)
                else
                    selectedColors.remove(R.color.red)
            answer = when{
                selectedColors.containsAll(listOf(R.color.red,R.color.blue))-> R.color.purple
                selectedColors.containsAll(listOf(R.color.red,R.color.yellow))-> R.color.orange
                selectedColors.containsAll(listOf(R.color.yellow,R.color.blue))-> R.color.green
                else -> 0 // an error code when the user selects only one color
            }
            Log.e("test","$selectedColors")
        }
        val blue:CheckBox=findViewById<CheckBox?>(R.id.blue).apply {
            this.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked)
                    if(selectedColors.size<2)
                        selectedColors.add(R.color.blue)
                else
                    selectedColors.remove(R.color.blue)
                answer = when{
                    selectedColors.containsAll(listOf(R.color.red,R.color.blue))-> R.color.purple
                    selectedColors.containsAll(listOf(R.color.red,R.color.yellow))-> R.color.orange
                    selectedColors.containsAll(listOf(R.color.yellow,R.color.blue))-> R.color.green
                    else -> 0 // an error code when the user selects only one color
                }
            }
        }
        val yellow:CheckBox=findViewById<CheckBox?>(R.id.red).apply {
            this.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked)
                    if(selectedColors.size>=2)
                        selectedColors.add(R.color.yellow)
                else
                    selectedColors.remove(R.color.yellow)
                answer = when{
                    selectedColors.containsAll(listOf(R.color.red,R.color.blue))-> R.color.purple
                    selectedColors.containsAll(listOf(R.color.red,R.color.yellow))-> R.color.orange
                    selectedColors.containsAll(listOf(R.color.yellow,R.color.blue))-> R.color.green
                    else -> 0 // an error code when the user selects only one color
                }
            }
        }
        val name = findViewById<EditText>(R.id.userName)


        val btn = findViewById<Button>(R.id.firstStep)
        btn.setOnClickListener{
            println(answer)
            if (answer!=0){
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("answer",answer)
                intent.putExtra("name",name.text)
                startActivity(intent)
            }else
                Toast.makeText(this,"Please select 2 Colors",Toast.LENGTH_SHORT).show()
        }
    }
}