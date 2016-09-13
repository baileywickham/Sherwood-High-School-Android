package com.github.bradypierce.sherwoodhighschool.Teachers

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.bindView

/**
 * Created by bradypierce on 9/10/16.
 */

class TeachersController: Controller(), ITeacher.View {

    val recyclerTeacher: RecyclerView by bindView(R.id.recycler_teacher_view)

    lateinit var presenter: ITeacher.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(R.layout.controller_teacher, container, false)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter = TeacherPresenter(this)
        recyclerTeacher.layoutManager = LinearLayoutManager(view.context)
        presenter.loadTeachers()
    }

    override fun showTeachers(teachers: List<Teacher>?) {
        recyclerTeacher.adapter = TeacherAdapter(teachers)
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}