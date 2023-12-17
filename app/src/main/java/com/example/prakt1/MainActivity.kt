package com.example.prakt1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.navFragment) as NavHostFragment
        navController = host.navController
        val sideBar = findViewById<NavigationView>(R.id.nav_view)
        sideBar?.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout = findViewById(R.id.drawer_layout))
        val toolBar = findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
        toolBar.setupWithNavController(navController, appBarConfiguration)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_right_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
}