package com.jprodriguezm.login.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDatabaseDao {
    @Insert
    fun insert(userLogin: UserLogin)

    @Update
    fun update(userLogin: UserLogin)

    @Query("SELECT * FROM users_login_table WHERE userId = :key")
    fun get(key: Long): UserLogin

    @Query("SELECT * FROM users_login_table WHERE email = :email")
    fun getByEmail(email: String): UserLogin

    @Delete
    fun delete(userLogin: UserLogin)

    @Delete
    fun deleteAllUsers(users: List<UserLogin>): Int

    @Query("DELETE FROM users_login_table")
    fun clear()

    @Query("SELECT * FROM users_login_table ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<UserLogin>>

    @Query("SELECT * FROM users_login_table ORDER BY userId DESC LIMIT 1")
    fun getLast(): UserLogin?
}