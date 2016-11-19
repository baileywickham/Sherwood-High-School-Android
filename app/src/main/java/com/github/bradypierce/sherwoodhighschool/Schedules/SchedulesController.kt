package com.github.bradypierce.sherwoodhighschool.Schedules

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.bindView

/**
 * Created by bradypierce on 9/10/16.
 */

class SchedulesController: Controller(), ISchedule.View {

    val recyclerSchedule: RecyclerView by bindView(R.id.recycler_schedule_view)

    lateinit var presenter: ISchedule.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(R.layout.controller_schedule, container, false)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter = SchedulePresenter(this)
        recyclerSchedule.layoutManager = LinearLayoutManager(view.context)
        presenter.loadSchedules()
    }

    override fun showSchedules(schedules: List<Schedule>?) {
        recyclerSchedule.adapter = ScheduleAdapter(schedules)
    }

    override fun showMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

}