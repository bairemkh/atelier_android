package com.esprit.diceapp.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.esprit.diceapp.R
import com.esprit.diceapp.views.fragments.ExperienceFragment

class Career : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        val frameLayout= findViewById<FrameLayout>(R.id.experienceFrameLayout)
        supportFragmentManager.beginTransaction().replace(R.id.experienceFrameLayout,ExperienceFragment()).commit()
    }
}