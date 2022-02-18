package com.oyun.ismekproject.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.oyun.ismekproject.model.UserInfo

//DataBase erişimini sağladık
@Dao
interface UserDao {

    //Select, insert, update, delete

    @Insert    //INSERT INTO userInfo () values ()
    fun insertUser(vararg userInfo: UserInfo)
    // @Insert annotation -> Bunun insert isteği belirtiyor
    // vararg -> multi elements added
    //UserInfo insert -> UserInfo("Murat", 12, 12)

    @Query("Select * from userinfo ORDER BY userName DESC")
    fun getUserInfo() : LiveData<List<UserInfo>>
    //DAO Data access object
    //Data class -> data class listesi ile multi data tutan bir liste oluşturduk.
    //Room setup
    //Room -> Entity, DAO, RoomDatabase

    @Query("DELETE FROM userinfo WHERE uid = :uuid")
    fun delete(uuid: Int) : Int

    //LiveData -> canlı data, gözlemlenebilir.


}