package com.esprit.diceapp.storage

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


object SharedPrefsApp {
    const val SHARED_PREFS="MySharedPref"
    /**
     * Write the variables you want to store here
     * **/
    private const val USER_TOKEN="UserToken"
    /**
     * Init in the concerned activity :
     *
     * val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
     * SharedPrefsApp.setToken(sharedPreferences, viewModel.token.value.orEmpty())
    */
    fun setToken(sharedPreferences:SharedPreferences,token:String){
        val editor = sharedPreferences.edit()
        editor.putString(USER_TOKEN, token).apply()
    }
    fun getToken(sharedPreferences:SharedPreferences):String{
        return sharedPreferences.getString(USER_TOKEN,"")!!
    }
    /** Write getters and your setters of the stored values to get them easily*/
}