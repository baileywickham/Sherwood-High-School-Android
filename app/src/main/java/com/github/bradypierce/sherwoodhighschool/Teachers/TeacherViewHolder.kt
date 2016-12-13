package com.github.bradypierce.sherwoodhighschool.Teachers

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.cleanPhoneNumber
import kotlinx.android.synthetic.main.item_teacher_view.view.*

/**
 * Created by bradypierce on 9/11/16.
 */

class TeacherViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view) {

    lateinit var popupMenu: PopupMenu
    val context = context

    fun bind(teacher: Teacher) {
        itemView.item_teacher_name.text = teacher.name
        itemView.item_teacher_position.text = teacher.position

        popupMenu = PopupMenu(context, itemView.item_teacher_overflow)
        popupMenu.menuInflater.inflate(R.menu.menu_teacher_overflow, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.teacher_overflow_email -> {
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:${teacher.email}")
                    context.startActivity(Intent.createChooser(intent, "Send Email"))
                    return@setOnMenuItemClickListener true
                }
                R.id.teacher_overflow_phone -> {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:${teacher.cleanPhoneNumber()}")
                    context.startActivity(intent)
                    return@setOnMenuItemClickListener true
                }
                /*R.id.teacher_overflow_website -> {
                    val intent = CustomTabsIntent.Builder()
                        .setToolbarColor(R.color.colorPrimary).build()
                    //TODO chrome custom tab
                    //intent.launchUrl(context, Uri.parse(teacher.websiteUrl()))
                    return@setOnMenuItemClickListener true
                }*/
                else -> {
                    return@setOnMenuItemClickListener false
                }
            }
        }

        itemView.item_teacher_overflow.setOnClickListener {
            popupMenu.show()
        }
    }

}