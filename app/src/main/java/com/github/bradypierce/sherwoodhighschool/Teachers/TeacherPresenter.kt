package com.github.bradypierce.sherwoodhighschool.Teachers

import com.github.bradypierce.sherwoodhighschool.Model.Interactor.RealmInteractor
import com.github.bradypierce.sherwoodhighschool.Teachers.Interactor.TeacherInteractor
import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.Teachers.Interactor.ITeacherNetwork

/**
 * Created by bradypierce on 9/10/16.
 */
class TeacherPresenter(view: ITeacher.View): ITeacher.Presenter {

    val realmInteractor = RealmInteractor()
    val teacherInteractor = TeacherInteractor()
    val teacherView = view

    override fun loadTeachers() {
        var teachers = realmInteractor.retrieveAllTeachers()
        if (teachers.size > 0) {
            teacherView.showTeachers(teachers)
        }
        requestTeachers(teachers)
    }

    fun requestTeachers(rTeachers: List<Teacher>) {
        teacherInteractor.retrieveTeachers(object : ITeacherNetwork.TeacherCallback {
            override fun onSuccess(teachers: List<Teacher>?) {
                if (rTeachers.size != teachers?.size) {
                    teacherView.showTeachers(teachers)
                }
            }

            override fun onFailure(error: Throwable) {
                teacherView.showMessage("Error")
            }
        })
    }

}