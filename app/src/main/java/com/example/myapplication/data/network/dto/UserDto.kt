package com.example.myapplication.data.network.dto

import kotlinx.serialization.Serializable

/** The shape returned by the server. */
@Serializable
data class UserDto(
    val id: String? = null,
    val fullname: String? = null,
    val email: String? = null,
    val password: String? = null,
    val birthdate: String? = null
)

/** The shape sent when creating an account. */
@Serializable
data class NewUserDto(
    val fullname: String,
    val email: String,
    val password: String,
    val birthdate: String
)
