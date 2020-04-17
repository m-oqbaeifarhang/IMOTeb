package com.example.imoteb

import android.view.Display

class CalculationMezaj
{
    companion object
    {
        fun Calculate(answer: IntArray?): ComputeMezajsResult
        {
            val CMR = ComputeMezajsResult()
            var counter = 0
            (answer)?.forEach {
                if(counter in 0..9)
                {
                    CMR.dam += it
                }
                if(counter in 10..24)
                {
                    CMR.safra += it
                }
                if(counter in 25..34)
                {
                    CMR.soda += it
                }
                if(counter in 35..47)
                {
                    CMR.balgham += it
                }
                counter++
            }
            CMR.dam = (7.5f * CMR.dam) / 10
            CMR.safra = (7.5f * CMR.safra) / 15
            CMR.soda = (7.5f * CMR.soda) / 10
            CMR.balgham = (7.5f * CMR.balgham) / 13

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
                    val soda=15-safra
                    CMR.safra += (2.5f * safra) / 15
                    CMR.soda += (2.5f * (15 - safra)) / 15
                }
                in 46..55 ->
                {
                    val soda=55-age
                    val balgham=10-soda
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