package com.github.bradypierce.sherwoodhighschool.Model

/**
 * Created by bradypierce on 11/6/16.
 */


class Schedule() {

    var name: String? = null

    var classes: List<SchoolClass>? = null

    constructor(name: String, classes: List<SchoolClass>) : this() {
        this.name = name
        this.classes = classes
    }

}

open class SchoolClass() {

    open var period: String? = null
    open var time: String? = null

    constructor(period: String, time: String) : this() {
        this.period = period
        this.time = time
    }

}