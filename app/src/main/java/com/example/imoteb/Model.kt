package com.example.imoteb

import android.content.res.Resources

class Model()
{
    companion object
    {
        var Answers: IntArray = IntArray(48) { -1 }
        var Age: Int = 0
        var KamKhuni = false
        lateinit var QuestionTitle: Array<String>
        var DamCount: Int = 9
        var SafraCount: Int = 14
        var SodaCount: Int = 9
        var BalghamCount: Int = 12
    }
}