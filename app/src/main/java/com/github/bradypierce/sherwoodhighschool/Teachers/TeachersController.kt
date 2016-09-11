package com.github.bradypierce.sherwoodhighschool.Teachers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.github.bradypierce.sherwoodhighschool.R

/**
 * Created by bradypierce on 9/10/16.
 */

class TeachersController: Controller(), ITeacher.View {

    lateinit var presenter: ITeacher.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        presenter = TeacherPresenter(this)
        val view: View = inflater.inflate(R.layout.controller_teacher, container, false)
        return view
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}