package com.oyun.ismekproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.orhanobut.hawk.Hawk
import com.oyun.ismekproject.adapter.UserNameListAdapter
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

   private val userNameListAdapter = UserNameListAdapter()
    var tempNameList: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        Hawk.init(applicationContext).build()

        tempNameList.add("Ahmet")
        tempNameList.add("Mehmet")
        tempNameList.add("yusuf")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")

        rv_name_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_name_list.adapter = userNameListAdapter

        userNameListAdapter.datayiAl(tempNameList)

        userNameListAdapter.nameClickListener = { isim, position->
            val intent = Intent(applicationContext,InformationActivity::class.java)
            intent.putExtra("adi", isim)
            intent.putExtra("position", position)
            startActivity(intent)
            Toast.makeText(this,"Tıklanılan isim : $isim - Sayısı : $position", Toast.LENGTH_SHORT).show()
        }

    }

}