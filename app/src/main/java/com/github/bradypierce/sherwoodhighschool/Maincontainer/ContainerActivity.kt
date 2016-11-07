package com.github.bradypierce.sherwoodhighschool.Maincontainer

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
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
import android.view.ViewGroup
import android.widget.Toast
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.github.bradypierce.sherwoodhighschool.Homescreen.HomescreenController
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Schedules.SchedulesController
import com.github.bradypierce.sherwoodhighschool.Student.StudentController
import com.github.bradypierce.sherwoodhighschool.Teachers.TeachersController
import com.github.bradypierce.sherwoodhighschool.Utils.bindView
import com.roughike.bottombar.BottomBar

class ContainerActivity : AppCompatActivity() {

    val toolbar: Toolbar by bindView(R.id.toolbar)
    val bottomBar: BottomBar by bindView(R.id.main_container_bottom_bar)
    val container: ViewGroup by bindView(R.id.main_container)

    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)
        setSupportActionBar(toolbar)

        router = Conductor.attachRouter(this, container, savedInstanceState);
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(HomescreenController()))
        }


        bottomBar.setOnTabSelectListener {
            when (it) {
                R.id.tab_homescreen -> router.pushController(RouterTransaction.with(HomescreenController()))
                R.id.tab_teachers   -> router.pushController(RouterTransaction.with(TeachersController()))
                R.id.tab_schedules  -> router.pushController(RouterTransaction.with(SchedulesController()))
                R.id.tab_student    -> router.pushController(RouterTransaction.with(StudentController()))
            }
        }
    }

    fun openCustomTab(url: String) {
        var builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(R.color.colorPrimary)
        var customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
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

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    companion object {

    }

}
