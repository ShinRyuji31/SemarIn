package com.example.application.auth.data.repository

import android.util.Log
import com.example.application.auth.data.model.Customer
import com.example.application.auth.data.model.User
import com.example.application.global.data.remote.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.status.SessionStatus
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.Flow

class UserRepository {

    companion object {
        private const val TAG = "UserRepository"
        private var instance: UserRepository? = null
        fun getInstance(): UserRepository {
            if (instance == null) {
                instance = UserRepository()
            }
            return instance!!
        }
    }

    private val auth = SupabaseClient.client.auth
    private val postgrest = SupabaseClient.client.postgrest

    val sessionStatus: Flow<SessionStatus> = auth.sessionStatus

    suspend fun signUp(
        email: String, 
        password: String, 
        username: String, 
        firstName: String, 
        lastName: String, 
        phoneNumber: String
    ): Result<Unit> {
        return try {
            Log.d(TAG, "Starting Supabase Auth sign up for: $email")
            
            // 1. Sign up to Supabase Auth
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            
            // 2. Retrieve the User ID from the current session
            // Note: This requires "Confirm Email" to be DISABLED in Supabase dashboard
            val userId = auth.currentUserOrNull()?.id 
                ?: throw Exception("Sign up successful but could not retrieve User ID. Please ensure 'Confirm Email' is DISABLED in Supabase Auth settings.")

            Log.d(TAG, "Auth successful. User ID: $userId. Proceeding to database insertion...")

            // 3. Prepare user profile object (matching your schema image)
            val userProfile = User(
                id = userId,
                username = username,
                firstName = firstName,
                lastName = if (lastName.isBlank()) null else lastName,
                email = email,
                phoneNumber = phoneNumber,
                password = password // Matching the 'password' column in your USER table
            )
            
            val customerProfile = Customer(userId = userId)
            
            // 4. Insert into the USER table
            Log.d(TAG, "Inserting into 'USER' table...")
            postgrest["USER"].insert(userProfile)
            
            // 5. Insert into the CUSTOMER table
            Log.d(TAG, "Inserting into 'CUSTOMER' table...")
            postgrest["CUSTOMER"].insert(customerProfile)
            
            Log.d(TAG, "Sign up and profile creation completed successfully.")
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Sign up flow failed: ${e.localizedMessage}", e)
            Result.failure(e)
        }
    }

    suspend fun signIn(email: String, password: String): Result<Unit> {
        return try {
            auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signOut() {
        auth.signOut()
    }

    suspend fun getUserProfile(): Result<User?> {
        return try {
            val userId = auth.currentUserOrNull()?.id ?: return Result.success(null)
            val user = postgrest["USER"].select {
                filter {
                    eq("user_id", userId)
                }
            }.decodeSingleOrNull<User>()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
