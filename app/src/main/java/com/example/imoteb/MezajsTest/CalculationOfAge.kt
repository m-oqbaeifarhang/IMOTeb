package com.example.imoteb.MezajsTest


import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import net.danlew.android.joda.JodaTimeAndroid
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class CalculationOfAge
{

    companion object
    {
        @RequiresApi(Build.VERSION_CODES.O)
        fun Calculate(DateOfBirth: Int): Int
        {
            val c:Calendar = Calendar.getInstance();
            val mYear = c.get(Calendar.YEAR)
            return mYear-(DateOfBirth+621)//621 فاصله تاریخ میلادی با شمسی است. این فرمول بعدا میتواند بهتر شود.
        }
    }

}