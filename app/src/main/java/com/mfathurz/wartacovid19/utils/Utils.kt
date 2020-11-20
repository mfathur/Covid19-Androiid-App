package com.mfathurz.wartacovid19.utils

import android.annotation.SuppressLint
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun numberConverter(num : Int):String =DecimalFormat().format(num)

    @SuppressLint("SimpleDateFormat")
    fun formatDate(date:String):String{
        var format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        format.timeZone=TimeZone.getTimeZone("UTC")
        val formattedDate=format.parse(date) as Date
        format=SimpleDateFormat("dd-MM-yyyy")
        return format.format(formattedDate)
    }
}