package com.mfathurz.wartacovid19.utils

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun numberConverter(num : Int):String =DecimalFormat().format(num)

    fun formatDate(date:String):String{
        var format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        format.timeZone=TimeZone.getTimeZone("UTC")
        val Date=format.parse(date)
        format=SimpleDateFormat("dd-MM-yyyy")
        return format.format(Date)
    }
}