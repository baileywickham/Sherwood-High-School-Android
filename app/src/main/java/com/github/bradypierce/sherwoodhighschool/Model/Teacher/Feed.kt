package com.github.bradypierce.sherwoodhighschool.Model.Teacher

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by bradypierce on 9/11/16.
 */

open class Feed {

    @SerializedName("entry")
    @Expose
    open var teachers: List<Teacher>? = null

}