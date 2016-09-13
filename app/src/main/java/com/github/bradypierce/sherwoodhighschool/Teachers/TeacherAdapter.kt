package com.github.bradypierce.sherwoodhighschool.Teachers

import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.bradypierce.sherwoodhighschool.Teachers.Interactor.Teacher
import com.github.bradypierce.sherwoodhighschool.R

/**
 * Created by bradypierce on 9/11/16.
 */

class TeacherAdapter(teachers: List<Teacher>?): RecyclerView.Adapter<TeacherViewHolder>() {

    lateinit var popupMenu: PopupMenu
    val teachers = teachers

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TeacherViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_teacher_view, parent, false)
        var viewHolder = TeacherViewHolder(view, parent!!.context)
        return viewHolder
    }

    override fun onBindViewHolder(holder: TeacherViewHolder?, position: Int) {
        holder?.bind(teachers!![position])
    }

    override fun getItemCount() = teachers!!.size

}