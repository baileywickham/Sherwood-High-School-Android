package com.github.bradypierce.sherwoodhighschool.Schedules.Detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.github.bradypierce.sherwoodhighschool.Model.Schedule
import com.github.bradypierce.sherwoodhighschool.R
import kotlinx.android.synthetic.main.activity_detail_schedule.*

/**
 * Created by bradypierce on 11/30/16.
 */
class ScheduleDetailActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_schedule)
        var schedule = intent.extras.getSerializable("Schedule") as Schedule

        toolbar.title = schedule.name
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recycler_schedule_detail_view.layoutManager = LinearLayoutManager(this)
        recycler_schedule_detail_view.adapter = ScheduleDetailAdapter(schedule.classes)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            this.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}