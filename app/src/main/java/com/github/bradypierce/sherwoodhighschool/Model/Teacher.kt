package com.github.bradypierce.sherwoodhighschool.Model

/**
 * Created by bradypierce on 11/30/16.
 */
class Teacher() {

    var name: String? = null
    var position: String? = null
    var email: String? = null
    var phone: String? = null

    constructor(name: String, position: String, email: String, phone: String) : this() {
        this.name = name
        this.position = position
        this.email = email
        this.phone = phone
    }

}