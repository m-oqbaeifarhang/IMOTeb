package com.example.imoteb

import android.content.res.Resources

class Model()
{
    companion object
    {
       var DefultAnswerArraysize:Int=48
        var Answers: IntArray?=null /*= IntArray(AnswerArraysize) { -1 }*/
        var Age: Int = 0
        var KamKhuni = false
        lateinit var QuestionTitle: MutableList<String>
        var DamQuestionCount: Int = 10
        var SafraQuestionCount: Int = 15
        var SodaQuestionCount: Int = 10
        var BalghamQuestionCount: Int = 13

        var MaxOfDamAnswerSize:Int=36
        var MaxOfSafraAnswerSize:Int=48
        var MaxOfSodaAnswerSize:Int=33
        var MaxOfBalghamAnswerSize:Int=48
        var NaderMohammad:Int=2
    }
}