package com.github.bradypierce.sherwoodhighschool.Model.Interactor

import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import java.util.*

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

    fun retrieveAllTeachers(): List<Teacher> {
        var realmResults: RealmResults<Teacher> = realm.where(Teacher::class.java).findAll()
        var teachers: MutableList<Teacher> = ArrayList()
        realmResults.forEach {
            teachers.add(it)
        }
        return teachers
    }

}