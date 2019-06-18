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
import com.myApp.goldy.modelview.DatabaseHelper
import com.myApp.goldy.view.activity.MainActivity


class LoginFragment : Fragment() {

    lateinit var usersDBHelper: DatabaseHelper
    lateinit var username:EditText
    lateinit var password:EditText


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        usersDBHelper = DatabaseHelper(this@LoginFragment.requireContext())

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.login_layout, container, false)
        //view.setTheme(R.style.AppTheme_NoActionBar)

        var mBackBtn = view!!.findViewById(R.id.back_btn) as Button
        var loginbtn = view!!.findViewById(R.id.login_btn) as Button
         username = view!!.findViewById(R.id.login_username) as EditText
         password = view!!.findViewById(R.id.login_password) as EditText
        var createAccount = view!!.findViewById(R.id.login_new_account) as TextView


        createAccount.setOnClickListener {

            val t = this.fragmentManager!!.beginTransaction()
            val mFrag = RegistrationFragment()
            t.hide(LoginFragment())
            loginbtn.visibility = View.INVISIBLE
            mBackBtn.visibility = View.INVISIBLE
            t.replace(R.id.login_layout, mFrag)
            t.commit()

        }

        mBackBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        loginbtn.setOnClickListener {
            validUserCheck(view)
        }
        return view
    }

        fun validUserCheck(v: View) {

            var name = username.text.toString()
            var password = password.text.toString()
         //   var checkLoginName = usersDBHelper.checkName(name)
          //  var checkLoginPass = usersDBHelper.checkPass(password)
            var checkNamePass=usersDBHelper.checkNamePass(name,password)

            if (checkNamePass==true) {
                Toast.makeText(context, "successful login", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(context, "wrong login", Toast.LENGTH_SHORT).show()

        }
}


/*
package com.myApp.goldy.view.fragments

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


class LoginFragment : Fragment() {

    lateinit var usersDBHelper: DatabaseHelper
    //var users = usersDBHelper.readAllUsers()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.login_layout, container, false)
        var mBackBtn = view!!.findViewById(R.id.back_btn) as Button
        var loginbtn = view!!.findViewById(R.id.login_btn) as Button
        var username = view!!.findViewById(R.id.login_username) as EditText
        var password = view!!.findViewById(R.id.login_password) as EditText
        var createAccount = view!!.findViewById(R.id.login_new_account) as TextView


        createAccount.setOnClickListener {

            val t = this.fragmentManager!!.beginTransaction()
            val mFrag = RegistrationFragment()
            t.hide(LoginFragment())
            loginbtn.visibility = View.INVISIBLE
            mBackBtn.visibility = View.INVISIBLE
            t.replace(R.id.login_layout, mFrag)
            t.commit()

        }

        mBackBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        loginbtn.setOnClickListener {

            var name = username.text.toString()
            var password = password.text.toString()
      */
/*      var checkLoginName = usersDBHelper.checkName(name)
            var checkLoginPass = usersDBHelper.checkPass(password)*//*

         //
            //
            //   val checkNamePass = usersDBHelper.checkNamePass(name, password)


         if(usersDBHelper.checkNamePass(name = name,password = password)==true)
             Toast.makeText(context, "successful login", Toast.LENGTH_SHORT).show()
else
             Toast.makeText(context, "wrong login", Toast.LENGTH_SHORT).show()




*/
/*
            if(name.equals(usersDBHelper.checkName(name)))
                Toast.makeText(context, "successful login", Toast.LENGTH_SHORT).show()

else{                  Toast.makeText(context, "wrong login", Toast.LENGTH_SHORT).show()
            }
*//*


            */
/*  val checkNamePass = usersDBHelper.checkNamePass(login_username, login_password)
              if (checkNamePass) {
                  Toast.makeText(context, "successful login", Toast.LENGTH_SHORT).show()

              }

              Toast.makeText(context, "illegal user name and password", Toast.LENGTH_SHORT).show()*//*

*/
/*
            if (checkLoginName == true || checkLoginPass == true)
                Toast.makeText(context, "successful login", Toast.LENGTH_SHORT).show()
            else {
                Toast.makeText(context, "illegal user name and password", Toast.LENGTH_SHORT).show()
            }*//*



        }

        return view
    }
*/
/*
    fun addUserLOgin(v: View) {
        var reg_name = this.reg_username.text.toString()
        var reg_pass = this.reg_password.text.toString()
        var reg_email = this.reg_email.text.toString()


        login_databaseHelper.insertUserLogin(User("0", name = reg_name, password = reg_pass, email = "null"))
        //clear all edittext s
        this.reg_email.setText("")
        this.reg_password.setText("")
        this.reg_username.setText("")
        this.reg_userId.setText("")


        if (reg_name.equals("") || reg_pass.equals("") || reg_email.equals("")) {
            Toast.makeText(context, "field empty...please fill all the fields", Toast.LENGTH_SHORT).show()

        } else
            Toast.makeText(context, "successful login", Toast.LENGTH_SHORT).show()

    }*//*




    fun validUserCheck(v:View){



    }

}*/
