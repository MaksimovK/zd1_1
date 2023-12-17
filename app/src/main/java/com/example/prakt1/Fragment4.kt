package com.example.prakt1

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController

class Fragment4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_4, container, false)
        val navController = NavHostFragment.findNavController(this)
        val bottomBar = fragmentLayout.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomBar?.setupWithNavController(navController)
        bottomBar.setOnNavigationItemSelectedListener { item ->
            navController.navigate(item.itemId)
            return@setOnNavigationItemSelectedListener true
        }
        return fragmentLayout
    }

}