package com.github.bradypierce.sherwoodhighschool.Model.Teacher

import android.util.Log
import com.github.bradypierce.sherwoodhighschool.Model.Realm.RealmInteractor
import com.github.bradypierce.sherwoodhighschool.Model.Teacher.Teacher
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import io.realm.RealmObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by bradypierce on 9/11/16.
 */

class TeacherInteractor {

    val realmInteractor = RealmInteractor()
    val baseUrl = "https://spreadsheets.google.com/"
    val requestKey = "1lq_kGuL4rgJDoAi6ZfTBMgIjktV82rKEMwDsStZirXg"

    val gson = GsonBuilder()
            .registerTypeAdapter(Teacher::class.java, TeacherDeserializer())
            .setExclusionStrategies(object : ExclusionStrategy {
        override fun shouldSkipField(f: FieldAttributes?): Boolean {
            return f?.declaredClass == RealmObject::class.java
        }

        override fun shouldSkipClass(clazz: Class<*>?): Boolean {
            return false
        }
    }).create()

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(baseUrl)
        .build()

    val teacherService: TeacherService = retrofit.create(
            TeacherService::class.java)

    fun retrieveTeachers(callback: TeacherCallback) {
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

    interface TeacherService {

        @GET("feeds/list/{key}/2/public/full?alt=json")
        fun getTeachers(@Path("key") key: String): Call<TeacherRequest>

    }

    interface TeacherCallback {

        fun onSuccess(teachers: List<Teacher>?)

        fun onFailure(error: Throwable)

    }

}