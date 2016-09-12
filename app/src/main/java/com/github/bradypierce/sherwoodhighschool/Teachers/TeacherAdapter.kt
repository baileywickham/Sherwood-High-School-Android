package com.github.bradypierce.sherwoodhighschool.Teachers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher
import com.github.bradypierce.sherwoodhighschool.R

/**
 * Created by bradypierce on 9/11/16.
 */

class TeacherAdapter(teachers: List<Teacher>?): RecyclerView.Adapter<TeacherViewHolder>() {

    val teachers = teachers

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TeacherViewHolder {
        return TeacherViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_teacher_view, parent, false))
    }

    override fun onBindViewHolder(holder: TeacherViewHolder?, position: Int) {
        holder?.bind(teachers!![position])
    }

    override fun getItemCount() = teachers!!.size

}