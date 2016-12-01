package com.github.bradypierce.sherwoodhighschool

import android.app.Application
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by bradypierce on 9/12/16.
 */

class SherwoodHighSchool: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }

}