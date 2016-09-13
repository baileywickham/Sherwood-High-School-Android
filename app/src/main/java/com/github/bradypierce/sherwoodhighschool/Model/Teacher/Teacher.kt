package com.github.bradypierce.sherwoodhighschool.Model.Teacher

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by bradypierce on 9/11/16.
 */

@RealmClass
open class Teacher: RealmObject() {

    @SerializedName("gsx\$staffname")
    @Expose
    @PrimaryKey
    open var name: String? = null

    @SerializedName("gsx\$position")
    @Expose
    open var position: String? = null

    @SerializedName("gsx\$email")
    @Expose
    open var email: String? = null

    @SerializedName("gsx\$phone")
    @Expose
    open var phone: String? = null

}