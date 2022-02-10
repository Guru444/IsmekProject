package com.oyun.ismekproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oyun.ismekproject.R
import kotlinx.android.synthetic.main.user_name_list_item_layout.view.*

class UserNameListAdapter : RecyclerView.Adapter<UserNameListAdapter.NameViewHolder>() {


    var nameClickListener: (String,Int) -> Unit = { _,_-> }
    var userNameListesi: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NameViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.user_name_list_item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: UserNameListAdapter.NameViewHolder, position: Int) {
        holder.bind(userNameListesi[position]) // 0  Ahmet, Mehmet
    }

    override fun getItemCount() = userNameListesi.size

    inner class NameViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(s: String) {
            itemView.tv_name.text = s
            itemView.setOnClickListener {
                nameClickListener(s,adapterPosition)
            }
        }
    }
    fun datayiAl(userNameList: ArrayList<String>){
        userNameListesi.addAll(userNameList)
        notifyDataSetChanged()
    }
}