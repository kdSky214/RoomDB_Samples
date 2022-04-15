package com.kd.roomdb.sample.database.dao

import androidx.room.*
import com.kd.roomdb.sample.database.model.UserProfile

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // 중복무시
    fun insert(user: UserProfile)

    @Update
    fun update(user: UserProfile)

    @Delete
    fun delete(user: UserProfile)

    @Query("SELECT * FROM userProfile")
    fun getAllUser():List<UserProfile>

    @Query("DELETE FROM userProfile WHERE name = :userName")
    fun deleteUserProfile(userName: String)
}