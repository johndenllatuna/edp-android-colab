package com.example.myapplication.domain.model

/** The safe user representation consumed by the screens. */
data class User(
    val id: String,
    val fullName: String,
    val email: String,
    val birthdate: String
)
