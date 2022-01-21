package com.oyun.ismekproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.oyun.ismekproject.adapter.UserNameListAdapter
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

   private val userNameListAdapter = UserNameListAdapter()
    var tempNameList: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        tempNameList.add("Ahmet")
        tempNameList.add("Mehmet")
        tempNameList.add("yusuf")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")
        tempNameList.add("merve")

        rv_name_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)
        rv_name_list.adapter = userNameListAdapter

        userNameListAdapter.datayiAl(tempNameList)

    }

}