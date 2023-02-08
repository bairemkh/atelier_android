package com.esprit.diceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val radioGrp= findViewById<RadioGroup>(R.id.resultsColors)
        val name=intent.getStringExtra("name")
        val answer=intent.getIntExtra("answer",-1)
        var userAnswer= 0
        radioGrp.setOnCheckedChangeListener{_, checkedId->
            userAnswer = when(checkedId){
                R.id.purple->R.color.purple
                R.id.green->R.color.green
                R.id.orange->R.color.orange
                else -> 0
            }
        }
        val btn=findViewById<Button>(R.id.activity2Btn)
        btn.setOnClickListener{
            Log.e("result","original answer is $answer vs user's answer is $userAnswer")

        }
    }

}