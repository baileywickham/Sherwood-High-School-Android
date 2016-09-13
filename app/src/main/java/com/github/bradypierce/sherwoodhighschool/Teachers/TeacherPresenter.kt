package com.github.bradypierce.sherwoodhighschool.Teachers

import android.util.Log
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.TeacherInteractor
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher
import io.realm.Realm
import io.realm.RealmResults
import java.util.*
import kotlin.properties.Delegates

/**
 * Created by bradypierce on 9/10/16.
 */
class TeacherPresenter(view: ITeacher.View): ITeacher.Presenter {

    val realm = Realm.getDefaultInstance()
    var realmResults: RealmResults<Teacher> by Delegates.notNull()
    val teacherInteractor = TeacherInteractor()
    val teacherView = view

    override fun loadTeachers() {
        realmResults = realm.where(Teacher::class.java).findAll()
        var teachers: MutableList<Teacher> = ArrayList()
        realmResults.forEach {
            teachers.add(it)
        }
        if (teachers.size > 0) {
            teacherView.showTeachers(teachers)
        }

        requestTeachers(teachers)
    }

    fun requestTeachers(rTeachers: List<Teacher>) {
        teacherInteractor.retrieveTeachers(object : TeacherInteractor.TeacherCallback {
            override fun onSuccess(teachers: List<Teacher>?) {
                if (rTeachers.size != teachers?.size) {
                    Log.d("TeacherPresenter", "Cached Different then Update")
                    teacherView.showTeachers(teachers)
                }
            }

            override fun onFailure(error: Throwable) {
                teacherView.showMessage("Error")
            }
        })
    }

}