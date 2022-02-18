package com.oyun.ismekproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.orhanobut.hawk.Hawk
import com.oyun.ismekproject.adapter.UserNameListAdapter
import com.oyun.ismekproject.model.UserInfo
import com.oyun.ismekproject.room.UserDao
import com.oyun.ismekproject.room.UserDataBase
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlin.coroutines.coroutineContext

class RecyclerviewActivity : AppCompatActivity() {

   private val userNameListAdapter = UserNameListAdapter()
    var userList: ArrayList<UserInfo> = arrayListOf()
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        Hawk.init(applicationContext).build()

        val db = Room.databaseBuilder(applicationContext, UserDataBase::class.java, "user").fallbackToDestructiveMigration().allowMainThreadQueries().build()
        userDao = db.userDAO()

        //Select All Table
        userDao.getUserInfo().observe(this, {
            userList.clear()
            for (x in it){
                Toast.makeText(this,x.uid.toString(), Toast.LENGTH_SHORT).show()
                userList.add(UserInfo(x.uid, x.userName, x.userAge, x.userHeight))
            }
            userNameListAdapter.datayiAl(userNameList = userList)
        })

        /*userList.add(UserInfo(userName = "Ahmet", userAge = 23, userHeight = 170))
        userList.add(UserInfo(userName = "Mehmet", userAge = 24, userHeight = 180))
        userList.add(UserInfo(userName = "Yusuf", userAge = 25, userHeight = 190))*/

        rv_name_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_name_list.adapter = userNameListAdapter

        //Delete Room
        userNameListAdapter.removeClickListener = {
            userDao.delete(it)
        }

        btn_add.setOnClickListener {
            //insert query
            userDao.insertUser(UserInfo(userName = edt_input.text.toString(), userAge = edt_age.text.toString().toInt(), userHeight = edt_height.text.toString().toInt()))
            userList.add(UserInfo(userName = edt_input.text.toString(), userAge = edt_age.text.toString().toInt(), userHeight = edt_height.text.toString().toInt()))
            userNameListAdapter.datayiAl(userList)
        }

        userNameListAdapter.nameClickListener = { isim, position->
            val intent = Intent(applicationContext,InformationActivity::class.java)
            intent.putExtra("adi", isim)
            intent.putExtra("position", position)
            startActivity(intent)
            Toast.makeText(this,"Tıklanılan isim : $isim - Sayısı : $position", Toast.LENGTH_SHORT).show()
        }
    }

    //DATABASE - VERİTABANI Local Database - Room arka planda SQlite -> android jetpack
    //Tablo -> Alanlar -> Alanların isimleri - > kullaniciAdi(String) - kullaniciSoyadi(String) - kullaniciYasi(Int)

}