package com.example.imoteb

import android.content.res.Resources
import android.provider.ContactsContract
import android.service.autofill.Dataset
import androidx.core.app.NotificationCompatSideChannelService
import com.github.mikephil.charting.data.DataSet
import java.security.KeyStore
import java.util.jar.Attributes

class Model()
{
    companion object
    {

        //  public enum class MezajhaEnum{dam,safra,soda,balgham}


        var EmtiyazSoalat = MutableList<Float>(32) { 1f }
        var questionTableList = mutableListOf<QuestionTable>()


        init
        {
            MakeEmtiyazSolatMutableList()
        }

        var Answers: MutableList<Int> = MutableList(32) { -1 }


        var Age: Int = 0
        var KamKhuni = false
        var Sex = false
        var Tahol = false
        lateinit var QuestionTitle: MutableList<String>

        var DamQuestionCount: Int = 7
        var SafraQuestionCount: Int = 9
        var SodaQuestionCount: Int = 9
        var BalghamQuestionCount: Int = 7

        var MaxOfDamAnswerSize: Float = 19f
        var MaxOfSafraAnswerSize: Float = 23f
        var MaxOfSodaAnswerSize: Float = 24f
        var MaxOfBalghamAnswerSize: Float = 18f

        fun MeghadDehiMotaghayerHa(): Unit
        {
            Answers = MutableList(32) { -1 }
            Age = 0
            KamKhuni = false
            Sex = false
            Tahol = false

            DamQuestionCount = 7
            SafraQuestionCount = 9
            SodaQuestionCount = 9
            BalghamQuestionCount = 7

            MaxOfDamAnswerSize = 19f
            MaxOfSafraAnswerSize = 23f
            MaxOfSodaAnswerSize = 24f
            MaxOfBalghamAnswerSize = 18f
            MakeEmtiyazSolatMutableList()
        }

        fun MakeEmtiyazSolatMutableList(): Unit
        {

            var counter = 0
            for(i in 0..31)
            {
                when
                {
                    counter in 0..6 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.dam))
                    }
                    counter in 7..15 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.safra))
                    }
                    counter in 16..24 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.soda))
                    }
                    counter in 25..31 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.balgham))
                    }
                }
                counter++;
            }

            questionTableList[0].Score = 2.0
            questionTableList[1].Score = 1.5
            questionTableList[4].Score = 1.5
            questionTableList[6].Score = 1.5
            questionTableList[9].Score = 1.5
            questionTableList[10].Score = 1.5
            questionTableList[11].Score = 1.5
            questionTableList[13].Score = 2.0
            questionTableList[16].Score = 2.0
            questionTableList[18].Score = 1.5
            questionTableList[22].Score = 1.5
            questionTableList[24].Score = 2.0
            questionTableList[25].Score = 2.0
            questionTableList[30].Score = 2.0

            var aaa: Double =
                questionTableList.filter { it.questionType == Globals.Companion.MezajhaEnum.safra }
                    .sumByDouble { a -> a.Score }
            //            EmtiyazSoalat = MutableList(32) { 1f }
            //            EmtiyazSoalat[ 0] = 2f
            //            EmtiyazSoalat[ 1] = 1.5f
            //            EmtiyazSoalat[ 4] = 1.5f
            //            EmtiyazSoalat[ 6] = 1.5f
            //            EmtiyazSoalat[ 9] = 1.5f
            //            EmtiyazSoalat[10] = 1.5f
            //            EmtiyazSoalat[11] = 1.5f
            //            EmtiyazSoalat[13] = 2f
            //            EmtiyazSoalat[16] = 2f
            //            EmtiyazSoalat[18] = 1.5f
            //            EmtiyazSoalat[22] = 1.5f
            //            EmtiyazSoalat[24] = 2f
            //            EmtiyazSoalat[25] = 2f
            //            EmtiyazSoalat[30] = 2f
        }
    }
}

data class QuestionTable(var questionType: Globals.Companion.MezajhaEnum,
    var answerType: Globals.Companion.AnswerType = Globals.Companion.AnswerType.YesSomeTimeNo,
    var Score: Double = 1.0)
{

}