package com.jprodriguezm.login.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "users_login_table", indices = [Index(value = ["email"], unique = true)])
data class UserLogin(
    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0L,

    @ColumnInfo(name = "email")
    var email: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "password_hash")
    var passwordHash: ByteArray? = null,

    @ColumnInfo(name = "rate")
    var rate: Int = -1
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserLogin

        if (passwordHash != null) {
            if (other.passwordHash == null) return false
            if (!passwordHash.contentEquals(other.passwordHash)) return false
        } else if (other.passwordHash != null) return false

        return true
    }

    override fun hashCode(): Int {
        return passwordHash?.contentHashCode() ?: 0
    }
}