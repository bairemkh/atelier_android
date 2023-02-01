package com.esprit.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.button)
        val img:ImageView=findViewById(R.id.imageDice)
        btn.setOnClickListener(View.OnClickListener {

            img.setImageResource(rollDice())
        })
    }
    private fun rollDice():Int{
        val dice:Dice = Dice(6)
        var x=0;
        val ran=dice.roll()
         when (ran) {
            1 -> x=R.drawable.dice_1
            2 -> x=R.drawable.dice_2
            3 -> x=R.drawable.dice_3
            4 -> x=R.drawable.dice_4
            5 -> x=R.drawable.dice_5
            6 -> x=R.drawable.dice_6
        }
        Toast.makeText(this, "roll dice $ran",Toast.LENGTH_LONG).show()
        return x
    }
}