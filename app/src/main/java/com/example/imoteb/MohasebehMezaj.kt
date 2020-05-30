package com.example.imoteb

import android.view.Display

class MohasebehMezaj
{
    enum class Mezajha
    {
        dam, safra, soda, balgham
    }

    companion object
    {
        fun Calculate(answer: MutableList<Int>): ComputeMezajsResult
        {
            val CMR = ComputeMezajsResult()
            var MezajCounter = 1
            var counter = 0
            var mezaj: Mezajha = Mezajha.dam
            (answer).forEach {
                var value = 0
                when(it)
                {
                    0 ->
                    {
                        value = 2
                    }
                    1 ->
                    {
                        value=1
                    }
                }

                when(mezaj)
                {
                    Mezajha.dam ->
                    {
                        CMR.dam += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.DamQuestionCount)
                        {
                            mezaj = Mezajha.safra
                            MezajCounter = 0
                        }
                    }
                    Mezajha.safra ->
                    {
                        CMR.safra += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.SafraQuestionCount)
                        {
                            mezaj = Mezajha.soda
                            MezajCounter = 0
                        }
                    }
                    Mezajha.soda ->
                    {
                        CMR.soda += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.SodaQuestionCount)
                        {
                            mezaj = Mezajha.balgham
                            MezajCounter = 0
                        }
                    }
                    Mezajha.balgham ->
                    {
                        CMR.balgham += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.BalghamQuestionCount)
                        {
                            MezajCounter = 0
                        }
                    }
                }
                MezajCounter++
                counter++;
            }
            val age = Model.Age
            when(age)
            {
                in 0..16 ->
                {
                    CMR.dam += 2f
                    Model.MaxOfDamAnswerSize += 2f
                }
                in 17..30 ->
                {
                    CMR.safra +=2f
                    Model.MaxOfSafraAnswerSize += 2f
                }
                in 31..45 ->
                {
                    val safra = 45 - age
                    val soda = 15 - safra
                    CMR.safra += (2f * safra) / 15
                    CMR.soda += (2f * soda) / 15
                    Model.MaxOfSafraAnswerSize += (2f * safra) / 15
                    Model.MaxOfSodaAnswerSize += (2f * soda) / 15
                }
                in 46..55 ->
                {
                    val soda = 55 - age
                    val balgham = 10 - soda
                    CMR.soda += (2f * soda) / 10
                    CMR.balgham += (2f * balgham) / 10
                    Model.MaxOfSodaAnswerSize += (2f * soda) / 10
                    Model.MaxOfBalghamAnswerSize += (2f * balgham) / 10
                }
                else ->
                {
                    CMR.balgham +=2f
                    Model.MaxOfBalghamAnswerSize +=2f
                }

            }
            CMR.dam = (5.25f * CMR.dam) / Model.MaxOfDamAnswerSize
            CMR.safra = (5.25f * CMR.safra) / Model.MaxOfSafraAnswerSize
            CMR.soda = (5.25f * CMR.soda) / Model.MaxOfSodaAnswerSize
            CMR.balgham = (5.25f * CMR.balgham) / Model.MaxOfBalghamAnswerSize


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

