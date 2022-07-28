package com.jprodriguezm.login.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jprodriguezm.login.database.UserDatabaseDao

class RegisterViewModel (
        val database: UserDatabaseDao,
        application: Application ) : AndroidViewModel(application) {

}