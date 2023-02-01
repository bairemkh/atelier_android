package com.esprit.diceapp

class Dice(var num:Int) {
    fun roll(): Int {
        return (1..num).random()
    }
}