package com.github.bradypierce.sherwoodhighschool.Schedules

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Schedules.Detail.ScheduleDetailActivity
import kotlinx.android.synthetic.main.fragment_schedule.*

/**
 * Created by bradypierce on 9/10/16.
 */

class SchedulesFragment() : Fragment(), ISchedule.View {

    lateinit var presenter: ISchedule.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_schedule, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = SchedulePresenter(this)
        recycler_schedule_view.layoutManager = LinearLayoutManager(context)
        presenter.loadSchedules()
    }

    override fun showSchedules(schedules: List<Schedule>?) {
        recycler_schedule_view.adapter = ScheduleAdapter(schedules) {
            var intent = Intent(context, ScheduleDetailActivity::class.java)
            var bundle = Bundle()
            bundle.putSerializable("Schedule", it)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun showMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

}