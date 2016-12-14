package com.github.bradypierce.sherwoodhighschool.Teachers

import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.R
import kotlinx.android.synthetic.main.fragment_teacher.*
import kotlinx.android.synthetic.main.bottom_sheet_teacher.*


/**
 * Created by bradypierce on 9/10/16.
 */

class TeacherFragment() : Fragment(), ITeacher.View {

    lateinit var presenter: ITeacher.Presenter
    lateinit var sheetView: View
    lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_teacher, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupBottomSheet()
        presenter = TeacherPresenter(this)
        recycler_teacher_view.layoutManager = LinearLayoutManager(context)
        presenter.loadTeachers()
    }

    override fun showTeachers(teachers: List<Teacher>?) {
        recycler_teacher_view.adapter = TeacherAdapter(teachers) {
            val teacher = it

            /*bottom_sheet_teacher_phone.setOnClickListener {
                Log.d("TeacherFragment", teacher.phone)
            }

            bottom_sheet_teacher_email.setOnClickListener {

            }*/
            bottomSheetDialog.show()
        }

    }

    override fun showMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    fun setupBottomSheet() {
        bottomSheetDialog = BottomSheetDialog(activity)
        sheetView = activity.layoutInflater.inflate(R.layout.bottom_sheet_teacher, null)
        bottomSheetDialog.setContentView(sheetView)
    }

}