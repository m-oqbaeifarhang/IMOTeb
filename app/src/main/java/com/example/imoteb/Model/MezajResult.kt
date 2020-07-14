package com.example.imoteb.Model

import android.util.Log
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.Ignore
import java.sql.Time
import java.time.Year
import java.util.*
import kotlin.time.days

open class MezajResult(var Dam: Float = 0f,
    var Safra: Float = 0f,
    var Soda: Float = 0f,
    var Balgham: Float = 0f) : RealmObject()
{
    fun SaveData(): Unit
    {

        var realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({
            val mezajResultObg = it.createObject(MezajResult::class.java)
            mezajResultObg.Dam = Dam
            mezajResultObg.Safra = Safra
            mezajResultObg.Soda = Soda
            mezajResultObg.Balgham = Balgham
        }, {
            Log.d("Tag", "On Success: Data Written Successfully!")
        }, {
            Log.d("Tag", "On Error: Error in saving Data!")
        })
    }
}

