package com.github.bradypierce.sherwoodhighschool.Schedules

import com.github.bradypierce.sherwoodhighschool.Model.Interactor.FirebaseInteractor
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * Created by bradypierce on 11/18/16.
 */


class SchedulePresenter(view: ISchedule.View) : ISchedule.Presenter {

    val firebaseInteractor = FirebaseInteractor()
    val fDatabase = FirebaseDatabase.getInstance()
    val fReference = fDatabase.getReference("Schedules")
    val view = view

    override fun loadSchedules() {
        fReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot?) {
                var schedules = firebaseInteractor.decodeSchedules(data)
                view.showSchedules(schedules)
            }

            override fun onCancelled(error: DatabaseError?) {
                view.showMessage(error?.message)
            }
        })
    }

}