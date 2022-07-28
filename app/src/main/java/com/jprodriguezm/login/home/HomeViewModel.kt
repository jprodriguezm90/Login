package com.jprodriguezm.login.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jprodriguezm.login.database.UserDatabaseDao

class HomeViewModel(
    val database: UserDatabaseDao,
    application: Application) : AndroidViewModel(application) {

}