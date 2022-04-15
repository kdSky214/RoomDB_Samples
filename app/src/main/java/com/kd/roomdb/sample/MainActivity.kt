package com.kd.roomdb.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.kd.roomdb.sample.database.UserDatabase
import com.kd.roomdb.sample.database.model.UserProfile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    var userList:List<UserProfile>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var scope:CoroutineScope(Dispatchers.)
        var scope = CoroutineScope(Dispatchers.Default)
        var db = UserDatabase.getInstance(applicationContext)
        scope.launch {
            db!!.userDao().insert(UserProfile(126,"내이름", "22","010-8888-1111"))
            db!!.userDao().insert(UserProfile(127,"내이름s", "11","010-8888-1123"))

            db!!.userDao().update(UserProfile(126,"내이름2", "23","010-8888-1111"))
            userList = db!!.userDao().getAllUser()
//            db!!.userDao().delete(UserProfile(126,"내이름2", "23","010-8888-1111"))
        }
        Log.e("db","${userList}")

    }
}