package com.myApp.goldy.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import com.myApp.goldy.R



public class SplashActivity :AppCompatActivity(){

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds
    lateinit var mProgress:ProgressBar

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    setContentView(R.layout.splash_layout)
mProgress=findViewById(R.id.mProgress)

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }
    private fun doWork() {
        var progress = 0
        while (progress < 100) {
            try {
                Thread.sleep(1000)
                mProgress.setProgress(progress)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            progress += 10
        }
    }

}