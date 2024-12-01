package com.example.cimena.presentation.screens.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cimena.CinemaApplication
import com.example.cimena.data.local.repository.AppFirebaseRepository

class AuthViewModel : ViewModel() {

    fun initDatabase(onSuccess: () -> Unit) {
        CinemaApplication.getAppContext()
        val repository = AppFirebaseRepository()
        repository.connectToDatabase(
            { onSuccess() },
            { Log.d("checkData", "Error $it") }
        )
    }
}