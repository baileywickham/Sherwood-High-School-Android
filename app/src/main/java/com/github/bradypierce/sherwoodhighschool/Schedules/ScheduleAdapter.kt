package com.github.bradypierce.sherwoodhighschool.Schedules

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.R

/**
 * Created by bradypierce on 11/18/16.
 */

class ScheduleAdapter(schedules: List<Schedule>?, onClick: (schedule: Schedule) -> (Unit)) : RecyclerView.Adapter<ScheduleViewHolder>() {

    val schedules = schedules
    val onClick = onClick

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScheduleViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_schedule_view, parent, false)
        val viewHolder = ScheduleViewHolder(view, parent!!.context, onClick)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder?, position: Int) {
        holder?.bind(schedules!![position])
    }

    override fun getItemCount() = schedules!!.size

}