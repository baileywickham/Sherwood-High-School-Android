package com.github.bradypierce.sherwoodhighschool.Schedules

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.R
import kotlinx.android.synthetic.main.item_schedule_view.view.*

/**
 * Created by bradypierce on 11/18/16.
 */

class ScheduleViewHolder(view: View, context: Context, onClick: (schedule: Schedule) -> (Unit)) : RecyclerView.ViewHolder(view) {

    val view = view
    val context = context
    val onClick = onClick

    fun bind(schdule: Schedule) {
        itemView.item_schedule_name.text = schdule.name
        view.setOnClickListener {
            onClick(schdule)
        }
    }

}