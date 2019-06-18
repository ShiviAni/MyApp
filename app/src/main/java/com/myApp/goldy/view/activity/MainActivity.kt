package com.myApp.goldy.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.myApp.goldy.R
import com.myApp.goldy.view.fragments.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mHomeLoginBtn: Button
    lateinit var mHomeRegBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        mHomeLoginBtn = findViewById(R.id.home_login_btn)
        mHomeRegBtn = findViewById(R.id.home_reg_btn)
        mHomeLoginBtn.setOnClickListener {
            val fragment = LoginFragment()
            mHomeLoginBtn.visibility = View.INVISIBLE
            mHomeRegBtn.visibility = View.INVISIBLE

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(
                R.id.frame_layout, fragment
            ) // fragmen container id in first parameter is the  container(Main layout id) of Activity
            transaction.commit()

        }
        mHomeRegBtn.setOnClickListener {
            val fragment = RegistrationFragment()
            mHomeLoginBtn.visibility = View.INVISIBLE
            mHomeRegBtn.visibility = View.INVISIBLE
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(
                R.id.frame_layout, fragment
            ) // fragmen container id in first parameter is the  container(Main layout id) of Activity
            transaction.commit()
        }
            val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        var bundle :Bundle ?=intent.extras
        if(null !=bundle){
            Toast.makeText(this, "hello ji", Toast.LENGTH_SHORT).show()

        }

    }





    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
         when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "Setting is done", Toast.LENGTH_SHORT).show()
            }


         /*    R.id.action_home -> {
                 intent= Intent(this, HomeActivity::class.java)
                 startActivity(intent)
             }*/


             R.id.action_main_screen -> {
                 intent=Intent(this, MainActivity::class.java)
                 startActivity(intent)
             }
    else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.dashboard_layout -> {
                        loadDashboard(frag1 = DashboardFragment())
                                    }
            R.id.customer_layout -> {
                loadCustomer(frag2 = CustomerFragment())

            }
          /*  R.id.home_layout -> {
                loadHome(frag3 = HomeFragment())
            }*/
            R.id.devices_layout -> {
                            loadDevice(frag4 = DeviceFragment())
            }
            R.id.video_layout -> {
                loadVideo(frag5 = VideoFragment())
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private  fun loadDashboard(frag1: DashboardFragment){
        val fm=supportFragmentManager.beginTransaction()
         fm.replace(R.id.frame_layout,frag1)
       // fm.hide(R.layout.home_layout,)
        fm.commit()
    }

    private  fun loadCustomer(frag2: CustomerFragment){

        val fm=supportFragmentManager.beginTransaction()
        fm.replace(R.id.frame_layout,frag2)
        fm.commit()

    }




 /*   private  fun loadHome(frag3: HomeFragment){

        val fm=supportFragmentManager.beginTransaction()
        fm.replace(R.id.frame_layout,frag3)
        fm.commit()

    }*/



    private  fun loadDevice(frag4: DeviceFragment){
        val fm=supportFragmentManager.beginTransaction()
        fm.replace(R.id.frame_layout,frag4)
        fm.commit()
    }

    private  fun loadVideo(frag5: VideoFragment){

        val fm=supportFragmentManager.beginTransaction()
        fm.replace(R.id.frame_layout,frag5)
        fm.commit()

    }

}
