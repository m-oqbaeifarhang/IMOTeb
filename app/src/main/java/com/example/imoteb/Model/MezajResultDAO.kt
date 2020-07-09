package com.example.imoteb.Model
import io.realm.Realm
class MezajResultDAO
{
private  var realm:Realm
    init
    {
        realm=Realm.getDefaultInstance()
    }
    fun save(mezajesult: Mezajesult):Unit
    {
        
    }
}