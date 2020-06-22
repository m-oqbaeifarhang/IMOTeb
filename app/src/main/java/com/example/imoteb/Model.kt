package com.example.imoteb

class Model()
{
    companion object
    {
        //var EmtiyazSoalat = MutableList<Float>(32) { 1f }
        var questionTableList = mutableListOf<QuestionTable>()

        init
        {
            MakeQueastionTable()
        }

        var Age: Int = 0
        var KamKhuni = false
        var Sex = false
        var Tahol = false

        //lateinit var QuestionTitle: MutableList<String>
        var TheHighestScore: Int = 2
        fun MeghadDehiMotaghayerHa(): Unit
        {
            Age = 0
            KamKhuni = false
            Sex = false
            Tahol = false
            if(questionTableList.any()) questionTableList.removeAll{a->!a.Deleted}
            MakeQueastionTable()
        }

        fun SetQuestionTitle(questionTitleList: List<String>): Unit
        {
            questionTitleList.forEachIndexed { index, s ->
                questionTableList[index].questionTitle = s
            }
        }

        fun MakeQueastionTable(): Unit
        {
            for(i in 0..31)
            {
                when(i)
                {
                    in 0..6 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.dam))
                    }
                    in 7..15 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.safra))
                    }
                    in 16..24 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.soda))
                    }
                    in 25..31 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.balgham))
                    }
                }
            }
            questionTableList[0].coefficient = 2.0
            questionTableList[1].coefficient = 1.5
            questionTableList[4].coefficient = 1.5
            questionTableList[6].coefficient = 1.5
            questionTableList[9].coefficient = 1.5
            questionTableList[10].coefficient = 1.5
            questionTableList[11].coefficient = 1.5
            questionTableList[13].coefficient = 2.0
            questionTableList[16].coefficient = 2.0
            questionTableList[18].coefficient = 1.5
            questionTableList[22].coefficient = 1.5
            questionTableList[24].coefficient = 2.0
            questionTableList[25].coefficient = 2.0
            questionTableList[30].coefficient = 2.0

        }
    }
}

data class QuestionTable(var questionTitle: String = "",
    var questionType: Globals.Companion.MezajhaEnum = Globals.Companion.MezajhaEnum.dam,
    var answerType: Globals.Companion.AnswerType = Globals.Companion.AnswerType.YesSomeTimeNo,
    var score: Double = -1.0,
    var coefficient: Double = 1.0,var Deleted:Boolean=false)
{

}