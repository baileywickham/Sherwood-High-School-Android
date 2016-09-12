package com.github.bradypierce.sherwoodhighschool.Teachers

import android.util.Log
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.TeacherInteractor
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher

/**
 * Created by bradypierce on 9/10/16.
 */
class TeacherPresenter(view: ITeacher.View): ITeacher.Presenter {

    val teacherInteractor = TeacherInteractor()
    val teacherView = view

    override fun loadTeachers() {
        Log.d("TeacherPresenter", "Called")
        teacherInteractor.retrieveTeachers(object : TeacherInteractor.TeacherCallback {
            override fun onSuccess(teachers: List<Teacher>?) {
                teacherView.showTeachers(teachers)
            }

            override fun onFailure(error: Throwable) {
                teacherView.showMessage("Error")
            }
        })
    }

}