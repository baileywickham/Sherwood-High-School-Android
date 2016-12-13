package com.github.bradypierce.sherwoodhighschool

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by bradypierce on 9/12/16.
 */

class SherwoodHighSchool: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}