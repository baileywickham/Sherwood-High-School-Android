package com.github.bradypierce.sherwoodhighschool.Teachers

import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher

/**
 * Created by bradypierce on 9/10/16.
 */
interface ITeacher {

    interface View {
        fun showMessage(message: String)

        fun showTeachers(teachers: List<Teacher>?)
    }

    interface Presenter {
        fun loadTeachers()
    }

}