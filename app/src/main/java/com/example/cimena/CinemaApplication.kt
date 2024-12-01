package com.example.cimena

import android.app.Application
import android.content.Context

class CinemaApplication : Application() {

    init {
        app = this
    }

    companion object {
        private lateinit var app: CinemaApplication

        fun getAppContext() : Context = app.applicationContext
    }

}