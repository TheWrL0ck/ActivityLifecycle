package com.boom.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class NewActivity : AppCompatActivity() {
    var titleName:String?="The Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var imgTony:ImageView
    lateinit var txtTName:TextView
    lateinit var txtEmail:TextView
    lateinit var txtPhone:TextView
    lateinit var imgSteve:ImageView
    lateinit var txtSName:TextView
    lateinit var txtSEmail:TextView
    lateinit var txtSPhone:TextView
    lateinit var imgHulk:ImageView
    lateinit var txtHName:TextView
    lateinit var txtHEmail:TextView
    lateinit var txtHPhone:TextView
    lateinit var btnLogOut:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_new)
        val intent=Intent(this@NewActivity,LoginActivity::class.java)
        imgTony=findViewById(R.id.imgTony)
        txtTName=findViewById(R.id.txtTName)
        txtEmail=findViewById(R.id.txtEmail)
        txtPhone=findViewById(R.id.txtPhone)
        imgSteve=findViewById(R.id.imgSteve)
        txtSName=findViewById(R.id.txtSName)
        txtSEmail=findViewById(R.id.txtSEmail)
        txtSPhone=findViewById(R.id.txtSPhone)
        imgHulk=findViewById(R.id.imgHulk)
        txtHName=findViewById(R.id.txtHName)
        txtHEmail=findViewById(R.id.txtHEmail)
        txtHPhone=findViewById(R.id.txtHPhone)
        btnLogOut=findViewById(R.id.btnLogOut)
        titleName=sharedPreferences.getString("Title","The Avengers")
        title=titleName
        btnLogOut.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(intent)
            finish()
        }
    }

}
