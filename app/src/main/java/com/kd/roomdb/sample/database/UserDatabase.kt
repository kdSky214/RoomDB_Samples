package com.kd.roomdb.sample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kd.roomdb.sample.database.dao.UserDao
import com.kd.roomdb.sample.database.model.UserProfile


//@Database(entities = arrayOf(User::class, Student::class), version = 1
@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object{
        private var instances: UserDatabase? = null

        fun getInstance(context: Context):UserDatabase?{
            if(instances == null){
                synchronized(UserDatabase::class){
                    instances = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user-database").build()
                }
            }
            return instances
        }
    }
}