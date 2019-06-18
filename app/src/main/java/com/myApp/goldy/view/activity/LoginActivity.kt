package com.myApp.goldy.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.myApp.goldy.R


class LoginActivity : AppCompatActivity(){

    lateinit var username:EditText
    lateinit var password:EditText
    lateinit var createAccount:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    setContentView(R.layout.login_layout)


        username=findViewById(R.id.login_username)
        password=findViewById(R.id.login_password)
        var loginbtn = findViewById(R.id.login_btn) as Button
        createAccount=findViewById(R.id.login_new_account)

        loginbtn.setOnClickListener {
            if ( username.length()>0 && password.length()>0) {

                Toast.makeText(applicationContext, "successful login", Toast.LENGTH_SHORT).show()
            }

           else
            Toast.makeText(applicationContext, "please enter correct username and password", Toast.LENGTH_SHORT).show()

        }

        createAccount.setOnClickListener {

            intent= Intent(this, RegistrationActivity::class.java)
            startActivity(intent)        }
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Login"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



   /* override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.login_layout,container,false)

    }*/

}