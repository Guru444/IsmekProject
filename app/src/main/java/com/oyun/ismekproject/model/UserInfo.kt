package com.oyun.ismekproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//Veritabanı tablomuz
@Entity
data class UserInfo(

    var userId: Int = 0,
    @ColumnInfo(name = "userName")
    var userName: String? = null,

    @ColumnInfo(name = "userAge")
    var userAge: Int? = null,

    @ColumnInfo(name = "userHeight")
    var userHeight: Int? = null
){
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
}

//  Tablo ismi -> UserInfo
//   uid    userName        userAge              userHeight
//    1         NUR        AGasE as             HEIGHT
//    2      NassAME        AGE              HEIGHT
//    3      NassAME        AGE              HEIGHT
//    4      NassAME        AGE              HEIGHT
//    5      NassAME        AGE              HEIGHT
//    6      NassAME        AGE              HEIGHT