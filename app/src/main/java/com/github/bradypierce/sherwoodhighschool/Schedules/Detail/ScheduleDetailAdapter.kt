package com.github.bradypierce.sherwoodhighschool.Schedules.Detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.bradypierce.sherwoodhighschool.Model.SchoolClass
import com.github.bradypierce.sherwoodhighschool.R

/**
 * Created by bradypierce on 11/30/16.
 */

class ScheduleDetailAdapter(classes: List<SchoolClass>?) :RecyclerView.Adapter<ScheduleDetailViewHolder>() {

    val classses = classes

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScheduleDetailViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_schedule_detail_view, parent, false)
        val viewHolder = ScheduleDetailViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ScheduleDetailViewHolder?, position: Int) {
        holder?.bind(classses!![position])
    }

    override fun getItemCount() = classses!!.size

}