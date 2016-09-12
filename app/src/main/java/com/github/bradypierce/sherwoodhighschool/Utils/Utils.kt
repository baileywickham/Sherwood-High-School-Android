package com.github.bradypierce.sherwoodhighschool.Utils

import android.util.Log

/**
 * Created by bradypierce on 9/11/16.
 */

inline fun String.cleanPhoneNumber(): String {
    var cleanNumber = this.replace("-", "")
    return cleanNumber
}