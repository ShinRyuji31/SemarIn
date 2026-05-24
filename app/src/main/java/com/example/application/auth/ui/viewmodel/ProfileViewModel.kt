package com.example.application.auth.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.auth.data.model.User
import com.example.application.auth.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ProfileUiState {
    object Loading : ProfileUiState()
    data class Success(val user: User) : ProfileUiState()
    data class Error(val message: String) : ProfileUiState()
    object ProfileNotFound : ProfileUiState()
    object Unauthenticated : ProfileUiState()
}

class ProfileViewModel(
    private val repository: UserRepository = UserRepository.getInstance()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState.Loading
            repository.getUserProfile()
                .onSuccess { user ->
                    if (user != null) {
                        _uiState.value = ProfileUiState.Success(user)
                    } else {
                        // User is authenticated but row in USER table is missing
                        _uiState.value = ProfileUiState.ProfileNotFound
                    }
                }
                .onFailure { error ->
                    val message = when {
                        error.message?.contains("USER.id does not exist", true) == true -> "Database configuration error. Please contact support."
                        else -> "Failed to load profile. Please check your connection."
                    }
                    _uiState.value = ProfileUiState.Error(message)
                }
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.signOut()
            _uiState.value = ProfileUiState.Unauthenticated
        }
    }
}
