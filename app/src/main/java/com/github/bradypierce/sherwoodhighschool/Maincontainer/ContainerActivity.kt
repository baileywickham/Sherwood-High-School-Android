package com.github.bradypierce.sherwoodhighschool.Maincontainer

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.bindView
import com.roughike.bottombar.BottomBar

class ContainerActivity : AppCompatActivity() {

    val toolbar: Toolbar by bindView(R.id.toolbar)
    val bottomBar: BottomBar by bindView(R.id.main_container_bottom_bar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)
        setSupportActionBar(toolbar)

        bottomBar.setOnTabSelectListener {
            when (it) {
                R.id.tab_homescreen -> Toast.makeText(this, "Homescreen", Toast.LENGTH_LONG).show()
                R.id.tab_teachers   -> Toast.makeText(this, "Teachers", Toast.LENGTH_LONG).show()
                R.id.tab_schedules  -> Toast.makeText(this, "Schedules", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
