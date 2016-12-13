package com.github.bradypierce.sherwoodhighschool.Teachers

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.R
import kotlinx.android.synthetic.main.fragment_teacher.*


/**
 * Created by bradypierce on 9/10/16.
 */

class TeacherFragment() : Fragment(), ITeacher.View {


    lateinit var presenter: ITeacher.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_teacher, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = TeacherPresenter(this)
        recycler_teacher_view.layoutManager = LinearLayoutManager(context)
        presenter.loadTeachers()
    }

    override fun showTeachers(teachers: List<Teacher>?) {
        recycler_teacher_view.adapter = TeacherAdapter(teachers)
    }

    override fun showMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}