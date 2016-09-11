package com.github.bradypierce.sherwoodhighschool.Teachers

/**
 * Created by bradypierce on 9/10/16.
 */
interface ITeacher {

    interface View {
        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadTeachers()
    }

}