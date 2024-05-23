package com.example.login_signup.Data

import android.widget.EditText
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getUser(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE username LIKE :name AND " +
            "password LIKE :pass LIMIT 1")
    fun findByName(name: String, pass: String): User

    @Insert
    fun insertUser(vararg username: EditText, password:String)

    @Delete
    fun delete(user: User)
}