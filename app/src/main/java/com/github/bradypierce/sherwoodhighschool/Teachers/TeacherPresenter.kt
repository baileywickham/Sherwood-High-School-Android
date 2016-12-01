package com.github.bradypierce.sherwoodhighschool.Teachers

import com.github.bradypierce.sherwoodhighschool.Model.Interactor.FirebaseInteractor
import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

/**
 * Created by bradypierce on 9/10/16.
 */
class TeacherPresenter(view: ITeacher.View): ITeacher.Presenter {

    val firebaseInteractor = FirebaseInteractor()
    val fDatabase = FirebaseDatabase.getInstance()
    val fReference = fDatabase.getReference("Teachers")
    val view = view

    override fun loadTeachers() {
        fReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot?) {
                var teachers = firebaseInteractor.decodeTeachers(data)
                view.showTeachers(teachers)
            }

            override fun onCancelled(error: DatabaseError?) {
                view.showMessage(error?.message)
            }
        })
    }
}