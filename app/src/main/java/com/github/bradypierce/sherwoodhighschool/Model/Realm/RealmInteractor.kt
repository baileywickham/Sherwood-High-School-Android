package com.github.bradypierce.sherwoodhighschool.Model.Realm

import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher
import io.realm.Realm
import io.realm.RealmObject

/**
 * Created by bradypierce on 9/12/16.
 */

class RealmInteractor {

    val realm = Realm.getDefaultInstance()

    fun writeList(list: List<Teacher>?) {
        realm.beginTransaction()
        list?.forEach {
            realm.copyToRealmOrUpdate(it)
        }
        realm.commitTransaction()
    }

}