package com.kd.roomdb.sample.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserProfile")
data class UserProfile(
    var id:Int,
    var name: String,
    var age: String,
    var phoneNumber: String
){
    @PrimaryKey(autoGenerate = false)
    var accountId : Int = id
}
