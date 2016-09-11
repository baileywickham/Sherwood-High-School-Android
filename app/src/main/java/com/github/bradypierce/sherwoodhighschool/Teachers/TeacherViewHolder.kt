package com.github.bradypierce.sherwoodhighschool.Teachers

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.bindView

/**
 * Created by bradypierce on 9/11/16.
 */

class TeacherViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val teacherName: TextView by bindView(R.id.item_teacher_name)
    val teacherPosition: TextView by bindView(R.id.item_teacher_position)
    val teacherOverflow: ImageButton by bindView(R.id.item_teacher_overflow)

    fun bind(teacher: Teacher) {
        teacherName.text = teacher.name
        teacherPosition.text = teacher.position
    }

}