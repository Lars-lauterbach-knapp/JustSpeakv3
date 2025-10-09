package com.devapps.justspeak.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devapps.justspeak.data.model.GoogleClientAuth
import com.devapps.justspeak.data.model.SignInResult
import com.devapps.justspeak.data.model.SignInState
import com.devapps.justspeak.data.model.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel(private val googleClientAuth: GoogleClientAuth) : ViewModel() {
    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> get() = _userData

    fun setUser(userData: UserData) {
        _userData.value = userData
    }

    fun onSignInResult(result: SignInResult) {
        _state.update {
            it.copy(
                isSignInSuccessful = result.data != null,
                signInError = result.errorMessage
            )
        }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}