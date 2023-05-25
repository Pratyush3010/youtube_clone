package com.example.new_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.new_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar : Toolbar
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.mytoolbar)

        setSupportActionBar(toolbar)

        statuscolor()
       // drawer()
        bottomNavigation()
    }


    fun statuscolor(){

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setBackgroundDrawableResource(R.drawable.background_action)

        }

    }

    fun drawer() {

        drawerToggle =
            ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)
        binding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.toggle)
        // val headerview : View =   binding.navView.inflateHeaderView(R.layout.drawer_header)
//        draweritem()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

    fun bottomNavigation(){
        val navcontroller = this.findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = findViewById(R.id.bottomnavview)
        navView.itemIconTintList = null
        navView.setupWithNavController(navcontroller)
    }

}