package com.example.application.auth.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.auth.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val repository: UserRepository = UserRepository.getInstance()
) : ViewModel() {

    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun signUp(
        email: String, 
        password: String, 
        username: String, 
        firstName: String, 
        lastName: String, 
        phoneNumber: String
    ) {
        if (email.isBlank() || password.isBlank() || username.isBlank() || firstName.isBlank() || phoneNumber.isBlank()) {
            _uiState.value = AuthUiState.Error("Please fill all required fields")
            return
        }

        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            repository.signUp(email, password, username, firstName, lastName, phoneNumber)
                .onSuccess {
                    _uiState.value = AuthUiState.Success
                }
                .onFailure { error ->
                    val message = when {
                        error.message?.contains("email_provider_disabled", true) == true -> 
                            "Sign up is currently disabled. Please contact support."
                        error.message?.contains("rate limit", true) == true -> 
                            "Too many requests. Please try again later."
                        else -> "Registration failed. ${error.localizedMessage}"
                    }
                    _uiState.value = AuthUiState.Error(message)
                }
        }
    }

    fun resetState() {
        _uiState.value = AuthUiState.Idle
    }
}
