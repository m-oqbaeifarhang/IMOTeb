package com.example.imoteb

import android.content.res.Resources
import java.security.KeyStore


class Model()
{

    companion object
    {
        var EmtiyazSoalat = MutableList<Float>(32) { 1f }

        init
        {
            MakeEmtiyazSolatMutableList()
        }

        var Answers: MutableList<Int> = MutableList(32) { -1 }
        var Age: Int = 0
        var KamKhuni = false
        var Sex=false
        var Tahol=false
        lateinit var QuestionTitle: MutableList<String>
        var DamQuestionCount: Int = 7
        var SafraQuestionCount: Int = 9
        var SodaQuestionCount: Int = 9
        var BalghamQuestionCount: Int = 7

        var MaxOfDamAnswerSize: Float = 9.5f
        var MaxOfSafraAnswerSize: Float = 11.5f
        var MaxOfSodaAnswerSize: Float = 12f
        var MaxOfBalghamAnswerSize: Float = 9f

        fun MakeEmtiyazSolatMutableList(): Unit
        {
            EmtiyazSoalat = MutableList(32) { 1f }
            EmtiyazSoalat[0] = 2f
            EmtiyazSoalat[1] = 1.5f
            EmtiyazSoalat[4] = 1.5f
            EmtiyazSoalat[6] = 1.5f
            EmtiyazSoalat[9] = 1.5f
            EmtiyazSoalat[10] = 1.5f
            EmtiyazSoalat[11] = 1.5f
            EmtiyazSoalat[13] = 2f
            EmtiyazSoalat[16] = 2f
            EmtiyazSoalat[18] = 1.5f
            EmtiyazSoalat[22] = 1.5f
            EmtiyazSoalat[24] = 2f
            EmtiyazSoalat[25] = 2f
            EmtiyazSoalat[30] = 2f
        }
    }
}
