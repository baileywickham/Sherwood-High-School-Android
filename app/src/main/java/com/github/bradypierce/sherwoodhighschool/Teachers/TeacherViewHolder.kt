package com.github.bradypierce.sherwoodhighschool.Teachers

import android.content.Context
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.bindView

/**
 * Created by bradypierce on 9/11/16.
 */

class TeacherViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view) {

    lateinit var popupMenu: PopupMenu
    val context = context
    val teacherName: TextView by bindView(R.id.item_teacher_name)
    val teacherPosition: TextView by bindView(R.id.item_teacher_position)
    val teacherOverflow: ImageButton by bindView(R.id.item_teacher_overflow)

    fun bind(teacher: Teacher) {
        teacherName.text = teacher.name
        teacherPosition.text = teacher.position

        popupMenu = PopupMenu(context, teacherOverflow)
        popupMenu.menuInflater.inflate(R.menu.menu_teacher_overflow, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.teacher_overflow_email -> {

                    return@setOnMenuItemClickListener true
                }
                R.id.teacher_overflow_phone -> {

                    return@setOnMenuItemClickListener true
                }
                else -> {
                    return@setOnMenuItemClickListener false
                }
            }
        }

        teacherOverflow.setOnClickListener {
            popupMenu.show()
        }
    }

}