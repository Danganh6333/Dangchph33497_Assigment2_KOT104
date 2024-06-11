package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.AccountEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.AccountRepository
import kotlinx.coroutines.launch

class AccountViewModel(val repository : AccountRepository) :ViewModel() {

    fun addAccount(accountEntity: AccountEntity, onResult: (Boolean) -> Unit){
        viewModelScope.launch {
            repository.signUp(accountEntity)
            onResult(true)
        }
    }
    fun signIn(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.signIn(email, password)
            onResult(result)
        }
    }

    fun isEmailTaken(email: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.isEmailTaken(email)
            onResult(result)
        }
    }
}