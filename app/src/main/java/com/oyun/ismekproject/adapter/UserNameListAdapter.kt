package com.oyun.ismekproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oyun.ismekproject.R
import com.oyun.ismekproject.model.UserInfo
import kotlinx.android.synthetic.main.user_name_list_item_layout.view.*

class UserNameListAdapter : RecyclerView.Adapter<UserNameListAdapter.NameViewHolder>() {

    //Lambda listener
    var nameClickListener: (String, Int) -> Unit = { _,_-> }
    var removeClickListener: (Int) -> Unit = {}
    var userNameListesi: ArrayList<UserInfo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NameViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.user_name_list_item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: UserNameListAdapter.NameViewHolder, position: Int) {
        holder.bind(userNameListesi[position]) // 0  Ahmet, Mehmet
    }

    override fun getItemCount() = userNameListesi.size

    inner class NameViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(user: UserInfo) {
            with(user){
                itemView.tv_name.text = userName
                itemView.tv_age.text = userAge.toString()
                itemView.tv_height.text = userHeight.toString()
            }
            itemView.srl_main.setOnClickListener {
                user.userName?.let {
                    nameClickListener(it, adapterPosition)
                }
            }
            itemView.remove_item.setOnClickListener {
                removeClickListener(user.userId)
                userNameListesi.removeAt(adapterPosition)
                notifyDataSetChanged()
            }
        }
    }
    fun datayiAl(userNameList: ArrayList<UserInfo>){
        userNameListesi.clear()
        userNameListesi.addAll(userNameList)
        notifyDataSetChanged()
    }

}