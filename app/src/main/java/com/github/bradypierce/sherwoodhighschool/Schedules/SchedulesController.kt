package com.github.bradypierce.sherwoodhighschool.Schedules

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.Model.SchoolClass
import com.github.bradypierce.sherwoodhighschool.R
import com.google.firebase.database.*
import java.util.*

/**
 * Created by bradypierce on 9/10/16.
 */

class SchedulesController: Controller() {

    val fDatabase = FirebaseDatabase.getInstance()
    val fReference = fDatabase.getReference("Schedules")

    //TODO implement schedule request

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(R.layout.controller_schedule, container, false)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        var schedules = ArrayList<Schedule>()
        var classes: List<SchoolClass> = listOf(SchoolClass("Period 1", "8:00 - 9:10"), SchoolClass("Period 2", "9:15 - 10:49"))


        schedules.add(Schedule("Regular", classes))
        schedules.add(Schedule("Advisory", classes))

        //fReference.setValue(schedules)
        retrieveData()
    }

    fun retrieveData() {
        fReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot?) {
                data?.children?.forEach {
                    var schedule = it.getValue(object : GenericTypeIndicator<HashMap<String, Object>>() {})
                    Log.i("SchedulesController", "Schedule Name: ${schedule.get("name")}")
                    var classes = schedule.get("classes") as List<HashMap<String, String>>
                    classes.forEach {
                        Log.i("SchedulesController", "Period: ${it.get("period")}")
                        Log.i("SchedulesController", "Time: ${it.get("time")}")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError?) {

            }
        })
    }

}