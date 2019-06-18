package com.myApp.goldy.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.myApp.goldy.R
import com.myApp.goldy.model.User
import com.myApp.goldy.modelview.DatabaseHelper
import com.myApp.goldy.view.activity.MainActivity
import kotlinx.android.synthetic.main.registration_layout.*

class RegistrationFragment : Fragment() {
    lateinit var usersDBHelper : DatabaseHelper

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        usersDBHelper = DatabaseHelper(this@RegistrationFragment.requireContext())

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.registration_layout, container, false)


        var mRegBackBTn = view!!.findViewById(R.id.reg_back_btn) as Button
        var regBtn = view!!.findViewById(R.id.reg_btn) as Button

        mRegBackBTn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }




/*
        var reg_username = view!!.findViewById(R.id.reg_username) as EditText
        var reg_password = view!!.findViewById(R.id.reg_password) as EditText
        var reg_email=view!!.findViewById(R.id.reg_email) as EditText
        var alreadyAccount = view!!.findViewById(R.id.reg_account_exist) as TextView*/

        regBtn.setOnClickListener {
            addUser(view)
        }
        return view


        mRegBackBTn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        return  view
    }




    fun addUser(v:View){
     //   var reg_userId = this.reg_userId.text.toString()
        var reg_name = this.reg_username.text.toString()
        var reg_pass = this.reg_password.text.toString()
        var reg_email = this.reg_email.text.toString()


        usersDBHelper.insertUser(User(name = reg_name,password = reg_pass,email=reg_email))
        //clear all edittext s
        this.reg_email.setText("")
        this.reg_password.setText("")
        this.reg_username.setText("")
      //  this.reg_userId.setText("")


        if (reg_name.equals("") || reg_pass.equals("")||reg_email.equals("")) {
            Toast.makeText(context, "field empty...please fill all the fields", Toast.LENGTH_SHORT).show()

        } else
            Toast.makeText(context, "successful login", Toast.LENGTH_SHORT).show()

    }

    }


