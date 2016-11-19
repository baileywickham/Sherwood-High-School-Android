package com.github.bradypierce.sherwoodhighschool.Model.Interactor

import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.Model.SchoolClass
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import java.util.*

/**
 * Created by bradypierce on 11/18/16.
 */


class FirebaseInteractor() {

    fun decodeSchedules(data: DataSnapshot?): List<Schedule> {
        val schedules = ArrayList<Schedule>()

        data?.children?.forEach {
            val rawSchedule = it.getValue(object : GenericTypeIndicator<HashMap<String, Object>>() {})
            val rawClasses = rawSchedule.get("classes") as List<HashMap<String, String>>
            var classes = ArrayList<SchoolClass>()
            rawClasses.forEach {
                classes.add(SchoolClass(it.get("period") as String, it.get("time") as String))
            }
            schedules.add(Schedule(rawSchedule.get("name") as String, classes))
        }

        return schedules
    }

}