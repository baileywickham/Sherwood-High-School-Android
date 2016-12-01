package com.github.bradypierce.sherwoodhighschool.Schedules.Detail

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.Model.SchoolClass
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.bindView

/**
 * Created by bradypierce on 11/30/16.
 */
class ScheduleDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val view = view
    val classPeriod: TextView by bindView(R.id.item_schedule_detail_period)
    val classTime: TextView by bindView(R.id.item_schedule_detail_time)

    fun bind(schoolClass: SchoolClass) {
        classPeriod.text = schoolClass.period
        classTime.text = schoolClass.time
    }

}