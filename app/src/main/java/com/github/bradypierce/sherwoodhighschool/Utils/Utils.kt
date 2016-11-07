package com.github.bradypierce.sherwoodhighschool.Utils

import com.github.bradypierce.sherwoodhighschool.Model.Teacher

/**
 * Created by bradypierce on 9/11/16.
 */

inline fun Teacher.cleanPhoneNumber(): String? {
    var cleanNumber = this.phone?.replace("-", "")
    return cleanNumber
}

inline fun Teacher.websiteUrl(): String? {
    var baseUrl = "http://shs.sherwood.k12.or.us/staff/teachers/"
    var first = this.name?.get(0)
    var last = this.name?.substring(this.name?.lastIndexOf(" ")!! + 1)
    var website = baseUrl + first + last
    return website.toLowerCase()
}