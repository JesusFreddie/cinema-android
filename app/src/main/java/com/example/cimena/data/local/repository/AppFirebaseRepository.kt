package com.example.cimena.data.local.repository

import DatabaseRepository
import com.example.cimena.utils.LOGIN
import com.example.cimena.utils.PASSWORD
import com.google.firebase.auth.FirebaseAuth

class AppFirebaseRepository : DatabaseRepository {
    private val fAuth = FirebaseAuth.getInstance()
    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        fAuth.signInWithEmailAndPassword(LOGIN, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                fAuth.createUserWithEmailAndPassword(LOGIN, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }
}