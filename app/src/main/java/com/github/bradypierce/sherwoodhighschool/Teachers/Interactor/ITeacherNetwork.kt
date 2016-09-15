package com.github.bradypierce.sherwoodhighschool.Teachers.Interactor

import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.Model.TeacherRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by bradypierce on 9/14/16.
 */
interface ITeacherNetwork {

    interface TeacherService {

        @GET("feeds/list/{key}/2/public/full?alt=json")
        fun getTeachers(@Path("key") key: String): Call<TeacherRequest>

    }

    interface TeacherCallback {

        fun onSuccess(teachers: List<Teacher>?)

        fun onFailure(error: Throwable)

    }

}