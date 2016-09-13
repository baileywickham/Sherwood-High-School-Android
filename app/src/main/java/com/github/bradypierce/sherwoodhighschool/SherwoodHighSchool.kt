package com.github.bradypierce.sherwoodhighschool

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlin.properties.Delegates

/**
 * Created by bradypierce on 9/12/16.
 */

class SherwoodHighSchool: Application() {

    var realmConfig: RealmConfiguration by Delegates.notNull()

    override fun onCreate() {
        super.onCreate()
        realmConfig = RealmConfiguration.Builder(this).build()
        Realm.setDefaultConfiguration(realmConfig)
    }

}