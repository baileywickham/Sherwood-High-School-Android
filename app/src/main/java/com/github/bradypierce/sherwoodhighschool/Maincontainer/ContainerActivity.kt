package com.github.bradypierce.sherwoodhighschool.Maincontainer

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Schedules.SchedulesFragment
import com.github.bradypierce.sherwoodhighschool.Teachers.TeacherFragment
import kotlinx.android.synthetic.main.activity_main_container.*

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)
        setSupportActionBar(toolbar)
        handleNavigation()
        supportFragmentManager.beginTransaction().add(R.id.main_container, TeacherFragment()).commit()
    }

    fun handleNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_teachers -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, TeacherFragment()).commit()
                }
                R.id.action_schedules -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, SchedulesFragment()).commit()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    fun openCustomTab(url: String) {
        var builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(R.color.colorPrimary)
        var customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }

}
