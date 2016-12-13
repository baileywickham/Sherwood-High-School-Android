package com.github.bradypierce.sherwoodhighschool.Schedules.Detail

import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.bradypierce.sherwoodhighschool.Model.SchoolClass
import kotlinx.android.synthetic.main.item_schedule_detail_view.view.*

/**
 * Created by bradypierce on 11/30/16.
 */
class ScheduleDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(schoolClass: SchoolClass) {
        itemView.item_schedule_detail_period.text = schoolClass.period
        itemView.item_schedule_detail_time.text = schoolClass.time
    }

}