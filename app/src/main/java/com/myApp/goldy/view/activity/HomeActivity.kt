package com.myApp.goldy.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.myApp.goldy.R
import com.myApp.goldy.view.fragments.LoginFragment
import com.myApp.goldy.view.fragments.RegistrationFragment
import android.view.View

class HomeActivity : AppCompatActivity() {

    lateinit var mHomeLoginBtn: Button
    lateinit var mHomeRegBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)

        val actionbar = supportActionBar
        actionbar!!.title = "Home Activity"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        mHomeLoginBtn = findViewById(R.id.home_login_btn)
        mHomeRegBtn = findViewById(R.id.home_reg_btn)
        mHomeLoginBtn.setOnClickListener {
            val fragment = LoginFragment()
            mHomeLoginBtn.visibility = View.INVISIBLE
            mHomeRegBtn.visibility = View.INVISIBLE

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(
                R.id.home_container, fragment
            ) // fragmen container id in first parameter is the  container(Main layout id) of Activity
            transaction.commit()

        }
        mHomeRegBtn.setOnClickListener {

            val fragment = RegistrationFragment()
            mHomeLoginBtn.visibility = View.INVISIBLE
            mHomeRegBtn.visibility = View.INVISIBLE

            val transaction = supportFragmentManager.beginTransaction()
            actionbar.setDisplayHomeAsUpEnabled(false)

            transaction.replace(
                R.id.home_container, fragment
            )
            // fragmen container id in first parameter is the  container(Main layout id) of Activity
            transaction.commit()

        }


        /*val actionbar = supportActionBar
        actionbar!!.title = "Home Activity"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        mHomeLoginBtn=findViewById(R.id.home_login_btn)
        mHomeRegBtn=findViewById(R.id.home_reg_btn)

        mHomeLoginBtn.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)   }

        mHomeRegBtn.setOnClickListener {
            intent= Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        intent=Intent(this, MainActivity::class.java)
        startActivity(intent)
        //onBackPressed()
        finish()
        return true*/


    }
/*    private fun loadFragment(fragment: Fragment) {
        // create a FragmentManager
        val fm = fragmentManager
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        val fragmentTransaction = fm.beginTransaction()
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frame_layout, fragment)
      //  fragmentTransaction.commit() // save the changes
    }*/

    override fun onSupportNavigateUp(): Boolean {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        //onBackPressed()
        finish()
        return true

    }
}


