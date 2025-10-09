package com.devapps.justspeak.data.model

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

