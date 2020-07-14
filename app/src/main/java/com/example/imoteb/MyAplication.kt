package com.example.imoteb

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyAplication: Application()
{
    override fun onCreate()
    {
        super.onCreate()
        Realm.init(this)
        var realmConfiguration:RealmConfiguration=RealmConfiguration.Builder()
            .name("IMOTebDb.realm")
            .schemaVersion(1)
           .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }
}