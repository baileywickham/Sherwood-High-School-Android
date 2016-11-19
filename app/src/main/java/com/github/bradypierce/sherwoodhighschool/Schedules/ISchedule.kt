package com.github.bradypierce.sherwoodhighschool.Schedules

import com.github.bradypierce.sherwoodhighschool.Model.Schedule

/**
 * Created by bradypierce on 11/18/16.
 */
interface ISchedule {

    interface View {
        fun showMessage(message: String?)

        fun showSchedules(schedules: List<Schedule>?)
    }

    interface Presenter {
        fun loadSchedules()
    }

}