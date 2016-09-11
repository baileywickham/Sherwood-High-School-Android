package com.github.bradypierce.sherwoodhighschool.Student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.github.bradypierce.sherwoodhighschool.R

/**
 * Created by bradypierce on 9/10/16.
 */

class StudentController: Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(R.layout.controller_student, container, false)
        return view
    }

}