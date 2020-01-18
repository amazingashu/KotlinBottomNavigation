package com.acronymslutions.kotlinbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = resources.getString(R.string.favorites)
        loadFragment(FavoriteFragment())




        tabView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_fav -> {
                    title = resources.getString(R.string.favorites)
                    loadFragment(FavoriteFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_home -> {
                    title = resources.getString(R.string.home)
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_settings -> {
                    title = resources.getString(R.string.settings)
                    loadFragment(SettingsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.logout -> {
                    title = resources.getString(R.string.logout)
                    loadFragment(Logout())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.login -> {
                    title = resources.getString(R.string.login)
                    loadFragment(Login_Fragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}