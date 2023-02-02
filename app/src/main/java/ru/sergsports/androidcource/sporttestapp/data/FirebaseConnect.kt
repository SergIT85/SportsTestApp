package ru.sergsports.androidcource.sporttestapp.presentation.startfragment

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.delay


    var firstUrlFB = ""
    suspend fun firebaseConnect() : String {/*
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        // тут возможно надо поменять дефолтное значение
        //remoteConfig.setDefaultsAsync
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        return firebaseConnectSimple(remoteConfig)*/
        delay(1500)
        return "https://dzen.ru/"
    }

    suspend fun firebaseConnectSimple (remoteConfig: FirebaseRemoteConfig): String {
        var flag = 0

        while (flag < 2) {
            if (firstUrlFB.isEmpty()){
                delay(1500)
                fetch(remoteConfig)
                //Тут надо вписать нужный ключ!!!
                firstUrlFB = remoteConfig.getString("check_link")////////////////////////////////////// вписать ключь
            }
            flag ++
        }
        return firstUrlFB
    }

    private fun fetch(remoteConfig: FirebaseRemoteConfig) {
        FirebaseRemoteConfig.getInstance().apply {
            fetch(0)
                .addOnCompleteListener {
                    remoteConfig.activate()
                }
        }
    }

