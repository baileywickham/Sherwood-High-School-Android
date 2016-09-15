package com.github.bradypierce.sherwoodhighschool.Teachers.Interactor

import android.util.Log
import com.github.bradypierce.sherwoodhighschool.Model.Interactor.NetworkInteractor
import com.github.bradypierce.sherwoodhighschool.Model.Interactor.RealmInteractor
import com.github.bradypierce.sherwoodhighschool.Model.TeacherRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by bradypierce on 9/11/16.
 */

class TeacherInteractor: NetworkInteractor("https://spreadsheets.google.com/") {

    val requestKey = "1lq_kGuL4rgJDoAi6ZfTBMgIjktV82rKEMwDsStZirXg"
    val realmInteractor = RealmInteractor()

    val teacherService: ITeacherNetwork.TeacherService = retrofit.create(
            ITeacherNetwork.TeacherService::class.java)

    fun retrieveTeachers(callback: ITeacherNetwork.TeacherCallback) {
        teacherService.getTeachers(requestKey).enqueue(object : Callback<TeacherRequest> {
            override fun onResponse(call: Call<TeacherRequest>?, response: Response<TeacherRequest>?) {
                var teachers = response?.body()?.feed?.teachers
                realmInteractor.writeList(teachers)
                callback.onSuccess(teachers)
            }

            override fun onFailure(call: Call<TeacherRequest>?, t: Throwable?) {
                Log.d("TeacherInteractor", "Failed")
                t?.printStackTrace()
            }
        })
    }

}