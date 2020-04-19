package com.example.imoteb

import android.view.Display

class CalculationMezaj
{
    companion object
    {
        fun Calculate(answer: IntArray?): ComputeMezajsResult
        {
            val CMR = ComputeMezajsResult()
            var counter = 1
            var temp: Int = 0
            var flag = "safra"
            (answer)?.forEach {
                if(counter in 1..Model.DamQuestionCount)
                {
                    temp = counter
                    CMR.dam += it
                } else if(counter in temp..(Model.SafraQuestionCount + temp) && flag == "safra")
                {
                    CMR.safra += it
                    if(counter + 1 !in temp..(Model.SafraQuestionCount + temp))
                    {
                        temp = counter
                        flag = "soda"
                    }
                } else if(counter in temp..(Model.SodaQuestionCount + temp) && flag == "soda")
                {
                    CMR.soda += it
                    if(counter + 1 !in temp..(Model.SodaQuestionCount + temp))
                    {
                        temp = counter
                        flag = "balgham"
                    }
                } else if(counter in temp..(Model.BalghamQuestionCount + temp) && flag == "balgham")
                {
                    CMR.balgham += it
                }
                counter++
            }
            CMR.dam = (7.5f * CMR.dam) / Model.MaxOfDamAnswerSize
            CMR.safra = (7.5f * CMR.safra) / Model.MaxOfSafraAnswerSize
            CMR.soda = (7.5f * CMR.soda) / Model.MaxOfSodaAnswerSize
            CMR.balgham = (7.5f * CMR.balgham) / Model.MaxOfBalghamAnswerSize

            val age = Model.Age
            when(age)
            {
                in 0..16 ->
                {
                    CMR.dam += 2.5f
                }
                in 17..30 ->
                {
                    CMR.safra += 2.5f
                }
                in 31..45 ->
                {
                    val safra = 45 - age
                    val soda = 15 - safra
                    CMR.safra += (2.5f * safra) / 15
                    CMR.soda += (2.5f * soda) / 15
                }
                in 46..55 ->
                {
                    val soda = 55 - age
                    val balgham = 10 - soda
                    CMR.soda += (2.5f * soda) / 10
                    CMR.balgham += (2.5f * balgham) / 10
                }
                else ->
                {
                    CMR.balgham += 2.5f
                }
            }
            return CMR
        }

        class ComputeMezajsResult
        {
            var dam: Float = 0f
            var safra: Float = 0f
            var soda: Float = 0f
            var balgham: Float = 0f
        }

    }
}

