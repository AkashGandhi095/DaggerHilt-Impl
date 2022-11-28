package com.app.daggerhiltapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // field injection
    @Inject lateinit var userLoginRepo: UserLoginRepo
    @Inject lateinit var sampleDependency: SampleDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userLoginRepo.doLogin("Akash Gandhi" , "XXX1232XXX")
        userLoginRepo.saveUserLoginCred("Akash Gandhi" , "XXX1232XXX")
        Log.d(Constants.TAG, "onCreate: ${sampleDependency.hashCode()} ")
        sampleDependency.doSomeWork()


    }
}

@Singleton
class SampleDependency @Inject constructor() {
    fun doSomeWork() {
        Log.d(Constants.TAG, "doSomeWork: calling...")
    }
}