package com.app.daggerhiltapp

import android.util.Log
import javax.inject.Inject


class UserLoginRepo @Inject constructor(
    // constructor injection
    private val firebaseSaveRepo :FirebaseDataSaveRepo
) {

    fun doLogin(name :String , password :String) {
        Log.d(Constants.TAG, "doLogin: $name is registered successfully!!")
    }

    fun saveUserLoginCred(name: String , password: String) {
        val userData = buildString {
            append(name)
            append(password)
        }
        firebaseSaveRepo.saveData(userData)
    }

}

class FirebaseDataSaveRepo @Inject constructor() {
    fun saveData(data: String) {
        Log.d(Constants.TAG, "Data Save to firebase successfully => $data")
    }
}