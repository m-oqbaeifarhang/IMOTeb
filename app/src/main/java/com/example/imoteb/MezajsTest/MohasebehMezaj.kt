package com.example.imoteb.MezajsTest

class MohasebehMezaj
{
    companion object
    {
        fun Calculate(questionTableList: MutableList<QuestionTable>): ComputeMezajsResult
        {
            val CMR = ComputeMezajsResult()
            var MaxOfDamAnswerSize =
                questionTableList.filter { a -> a.questionType == MezajsEnum.dam }
                    .sumByDouble { a -> a.coefficient } * Model.TheHighestScore
            var MaxOfSafraAnswerSize =
                questionTableList.filter { a -> a.questionType == MezajsEnum.safra }
                    .sumByDouble { a -> a.coefficient } * Model.TheHighestScore
            var MaxOfSodaAnswerSize =
                questionTableList.filter { a -> a.questionType == MezajsEnum.soda }
                    .sumByDouble { a -> a.coefficient } * Model.TheHighestScore
            var MaxOfBalghamAnswerSize =
                questionTableList.filter { a -> a.questionType == MezajsEnum.balgham }
                    .sumByDouble { a -> a.coefficient } * Model.TheHighestScore

            //در این قسمت ضریب سوالات به جواب سوالات ضرب میشود و در جواب سوالات قرار میگیرد
            questionTableList.forEachIndexed { index, questionTable ->
                questionTableList[index].score =
                    questionTable.score * questionTable.coefficient
            }
            CMR.dam = Model.questionTableList.filter { a -> a.questionType == MezajsEnum.dam }
                .sumByDouble { a -> a.score }.toFloat()
            CMR.safra = Model.questionTableList.filter { a -> a.questionType == MezajsEnum.safra }
                .sumByDouble { a -> a.score }.toFloat()
            CMR.soda = Model.questionTableList.filter { a -> a.questionType == MezajsEnum.soda }
                .sumByDouble { a -> a.score }.toFloat()
            CMR.balgham =
                Model.questionTableList.filter { a -> a.questionType == MezajsEnum.balgham }
                    .sumByDouble { a -> a.score }.toFloat()
            val age = Model.Age
            when(age)
            {
                in 0..16 ->
                {
                    CMR.dam += 2f
                    MaxOfDamAnswerSize += 2.0
                }
                in 17..30 ->
                {
                    CMR.safra += 2f
                    MaxOfSafraAnswerSize += 2.0
                }
                in 31..45 ->
                {
                    val safra = 45 - age
                    val soda = 15 - safra
                    CMR.safra += (2f * safra) / 15
                    CMR.soda += (2f * soda) / 15
                    MaxOfSafraAnswerSize += (2.0 * safra) / 15
                    MaxOfSodaAnswerSize += (2.0 * soda) / 15
                }
                in 46..55 ->
                {
                    val soda = 55 - age
                    val balgham = 10 - soda
                    CMR.soda += (2f * soda) / 10
                    CMR.balgham += (2f * balgham) / 10
                    MaxOfSodaAnswerSize += (2.0 * soda) / 10
                    MaxOfBalghamAnswerSize += (2.0 * balgham) / 10
                }
                else ->
                {
                    CMR.balgham += 2f
                    MaxOfBalghamAnswerSize += 2.0
                }
            }
            CMR.dam = ((5.25 * CMR.dam) / MaxOfDamAnswerSize).toFloat()
            CMR.safra = ((5.25 * CMR.safra) / MaxOfSafraAnswerSize).toFloat()
            CMR.soda = ((5.25 * CMR.soda) / MaxOfSodaAnswerSize).toFloat()
            CMR.balgham = ((5.25 * CMR.balgham) / MaxOfBalghamAnswerSize).toFloat()

            CMR.dam += 3f
            CMR.safra += 3f
            CMR.soda += 3f
            CMR.balgham += 3f
            return CMR
        }
    }

    class ComputeMezajsResult
    {
        var dam: Float = 0f
        var safra: Float = 0f
        var soda: Float = 0f
        var balgham: Float = 0f
    }
}

