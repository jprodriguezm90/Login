package com.jprodriguezm.login.loginaccess

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jprodriguezm.login.database.UserDatabaseDao
import com.jprodriguezm.login.database.UserLogin
import kotlinx.coroutines.*

class LoginViewModel (
        val database: UserDatabaseDao,
        application: Application ) : AndroidViewModel(application) {

        private var viewModelJob = Job()

        override fun onCleared() {
                super.onCleared()
                viewModelJob.cancel()
        }

        private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

        private var login = MutableLiveData<UserLogin?>()


        private val _navigateToRegister = MutableLiveData<UserLogin>()
        val navigateToRegister: LiveData<UserLogin>
                get() = _navigateToRegister
        fun doneNavigating(){
                _navigateToRegister.value = null
        }


        init {

        }

        private fun loginAccess(email: String){
                uiScope.launch {
                        login.value = getLoginAccessFromDatabase(email)
                }
        }

        private suspend fun getLoginAccessFromDatabase(email: String): UserLogin?{
                return withContext(Dispatchers.IO){
                        var user = database.getByEmail(email)
                        user
                }
        }

        fun onClear(){
                uiScope.launch {
                        clear()
                        login.value = null
                }
        }

        private suspend fun clear() {
                withContext(Dispatchers.IO){
                        database.clear()
                }
        }

}