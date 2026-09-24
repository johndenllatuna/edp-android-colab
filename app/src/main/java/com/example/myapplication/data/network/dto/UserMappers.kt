package com.example.myapplication.data.network.dto

import com.example.myapplication.domain.model.User

/** Maps the server DTO to the password-free model used by the UI. */
fun UserDto.toDomain(): User = User(
    id = id ?: "",
    fullName = fullname?.trim() ?: "(no name)",
    email = email?.trim() ?: "",
    birthdate = birthdate ?: "(not set)"
)
