package com.example.modul5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = HomeFragment.newInstance("test 1", "test2")
        val bottom_navi_view = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottom_navi_view.setOnNavigationItemSelectedListener(menuItemSelected)
        addFragment(fragment)
    }

    //mendeteksi menu item yg diklik
    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.iconhome -> {
                val fragment = HomeFragment.newInstance("test 1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.iconsetting -> {
                val fragment = LainFragment.newInstance("test 1", "test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    //memanggil frame layout
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                com.google.android.material.R.anim.design_bottom_sheet_slide_in,
                com.google.android.material.R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.content, fragment, fragment::class.java.simpleName)
            .commit()
    }
}