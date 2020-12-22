package com.boom.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {
    lateinit var imgAven:ImageView
    lateinit var etUser:EditText
    lateinit var etPass:EditText
    lateinit var btnLog:Button
    lateinit var txtFor:TextView
    lateinit var txtSign:TextView
    val validMobile="1234567890"
    val validPass= arrayOf("tony","steve","thanos")
    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        if(isLoggedIn){
            intent=Intent(this@LoginActivity,NewActivity::class.java)
            startActivity(intent)
            finish()
        }
        title="Log In"
        imgAven=findViewById(R.id.imgAven)
        etUser=findViewById(R.id.etUser)
        etPass=findViewById(R.id.etPass)
        btnLog=findViewById(R.id.btnLog)
        txtFor=findViewById(R.id.txtFor)
        txtSign=findViewById(R.id.txtSign)




        btnLog.setOnClickListener {
            val mobile=etUser.text.toString()
            val password=etPass.text.toString()
            var nameOfAvenger="Avenger"
            val intent=Intent(this@LoginActivity,NewActivity::class.java)
            if(mobile==validMobile)
            {
                when {
                    password == validPass[0] -> {
                        nameOfAvenger = "Iron Man"
                        savePreferences(nameOfAvenger)
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                    password == validPass[1] -> {
                        nameOfAvenger = "Captain America"
                        savePreferences(nameOfAvenger)
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                    password == validPass[2] -> {
                        nameOfAvenger = "Avenger"
                        savePreferences(nameOfAvenger)
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                }

            }
            else{
                Toast.makeText(this@LoginActivity,"Maza aya dabake?",Toast.LENGTH_LONG).show()
            }
        }
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}
