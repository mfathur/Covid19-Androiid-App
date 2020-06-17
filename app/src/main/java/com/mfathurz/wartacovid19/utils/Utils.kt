package com.mfathurz.wartacovid19.utils

import java.text.DecimalFormat

object Utils {
    fun numberConverter(num : Int):String =DecimalFormat().format(num)
}