package com.github.bradypierce.sherwoodhighschool.Model.Interactor

import com.github.bradypierce.sherwoodhighschool.Model.Teacher
import com.github.bradypierce.sherwoodhighschool.Teachers.Interactor.TeacherDeserializer
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import io.realm.RealmObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by bradypierce on 9/14/16.
 */
abstract class NetworkInteractor(baseUrl: String) {

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

}