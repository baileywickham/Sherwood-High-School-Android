package com.github.bradypierce.sherwoodhighschool.Teachers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.R
import com.github.bradypierce.sherwoodhighschool.Utils.cleanPhoneNumber
import kotlinx.android.synthetic.main.bottom_sheet_teacher.*

/**
 * Created by bradypierce on 12/14/16.
 */

class TeacherBottomFragment() : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.bottom_sheet_teacher, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var teacher = arguments.getSerializable("Teacher") as Teacher

        bottom_sheet_teacher_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${teacher.cleanPhoneNumber()}")
            context.startActivity(intent)
            dismiss()
        }

        bottom_sheet_teacher_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${teacher.email}")
            context.startActivity(Intent.createChooser(intent, "Send Email"))
            dismiss()
        }
    }

}