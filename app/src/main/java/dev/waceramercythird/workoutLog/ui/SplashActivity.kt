package dev.waceramercythird.workoutLog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var  sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = getSharedPreferences("WORKOUTlOG_PREFS", MODE_PRIVATE)


        var accessToken =sharedPrefs.getString("ACCESS_TOKEN", "").toString()
        if(accessToken.isBlank()){
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
//            add define the document for the API DOCS send through class room.
        //            add the endpoint of API
        }

    }
}