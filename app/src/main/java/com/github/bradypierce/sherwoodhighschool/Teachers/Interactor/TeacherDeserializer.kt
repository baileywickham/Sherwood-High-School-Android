package com.github.bradypierce.sherwoodhighschool.Teachers.Interactor

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

/**
 * Created by bradypierce on 9/11/16.
 */
class TeacherDeserializer: JsonDeserializer<Teacher> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Teacher {
        val jsonObject: JsonObject? = json?.asJsonObject
        var teacher: Teacher = Teacher()

        teacher.name = jsonObject?.get("gsx\$staffname")?.asJsonObject?.get("\$t")?.asString
        teacher.position = jsonObject?.get("gsx\$position")?.asJsonObject?.get("\$t")?.asString
        teacher.email = jsonObject?.get("gsx\$email")?.asJsonObject?.get("\$t")?.asString
        teacher.phone = jsonObject?.get("gsx\$phone")?.asJsonObject?.get("\$t")?.asString

        return teacher
    }

}