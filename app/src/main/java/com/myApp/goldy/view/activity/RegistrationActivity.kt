package com.myApp.goldy.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.myApp.goldy.R



class RegistrationActivity : AppCompatActivity(){

    lateinit var accountExist: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_layout)

        accountExist=findViewById(R.id.reg_account_exist)
        accountExist.setOnClickListener {
            intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Registration"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



/*
     val activity = this@RegistrationFragment



     lateinit var textInputEditTextName: EditText
     lateinit var textInputEditTextPassword: EditText
     lateinit var textInputEditTextEmail: EditText
    lateinit var textInputButtonRegistration:Button

    private lateinit var inputValidation: InputValidation
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.registration_layout)

        // hiding the action bar
        supportActionBar!!.hide()

        // initializing the views
        initViews()

        // initializing the listeners
        initListeners()

        // initializing the objects
        initObjects()
    }

    *//**
     * This method is to initialize views
     *//*
    private fun initViews() {
        textInputEditTextName = findViewById<View>(R.id.reg_username) as EditText
        textInputEditTextEmail = findViewById<View>(R.id.reg_email) as EditText
        textInputEditTextPassword = findViewById<View>(R.id.reg_password) as EditText
        textInputButtonRegistration = findViewById<View>(R.id.reg_btn) as Button




    }

    *//**
     * This method is to initialize listeners
     *//*
    private fun initListeners() {

        textInputButtonRegistration!!.setOnClickListener(this)
    }

    *//**
     * This method is to initialize objects to be used
     *//*
    private fun initObjects() {

        databaseHelper = DatabaseHelper(activity)
        inputValidation = InputValidation(activity)

    }

    *//**
     * This implemented method is to listen the click on view
     *
     * @param v
     *//*
 *//*   override fun onClick(v: View) {
        when (v.id) {
            R.id.appCompatButtonLogin -> verifyFromSQLite()
            R.id.textViewLinkRegister -> {
                // Navigate to RegisterActivity
                val intentRegister = Intent(applicationContext, RegisterActivity::class.java)
                startActivity(intentRegister)
            }
        }
    }*//*

    *//**
     * This method is to validate the input text fields and verify login credentials from SQLite
     *//*
    private fun verifyFromSQLite() {

        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextName!!, textInputEditTextEmail!!, getString(R.string.action_home))) {
            return
        }
        if (!inputValidation!!.isInputEditTextEmail(this.textInputEditTextEmail!!, getString(R.string.action_home))) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextPassword!!, textInputLayoutPassword!!, getString(R.string.error_message_email))) {
            return
        }

        if (databaseHelper!!.checkUser(textInputEditTextEmail!!.text.toString().trim { it <= ' ' }, textInputEditTextPassword!!.text.toString().trim { it <= ' ' })) {


            val accountsIntent = Intent(activity, UsersListActivity::class.java)
            accountsIntent.putExtra("EMAIL", textInputEditTextEmail!!.text.toString().trim { it <= ' ' })
            emptyInputEditText()
            startActivity(accountsIntent)


        } else {

            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView!!, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show()
        }
    }

    *//**
     * This method is to empty all input edit text
     *//*
    private fun emptyInputEditText() {
        textInputEditTextEmail!!.text = null
        textInputEditTextPassword!!.text = null
    }*/
}