package com.alpianreza.githubapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alpianreza.githubapp.databinding.ItemRowUserBinding
import com.alpianreza.githubapp.model.Users

class ListUserAdapter (private val listUsers: ArrayList<Users>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>(){

    private lateinit var oneItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.oneItemClickCallBack = onItemClickCallBack
    }

    class ListViewHolder (val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallBack {
        fun onItemClicked(data: Users)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, avatar, company) = listUsers[position]
        holder.binding.tvName.text = name
        holder.binding.tvUsername.text = username
        holder.binding.tvCompany.text = company
        holder.binding.myAvatar.setImageResource(avatar)

        holder.itemView.setOnClickListener { oneItemClickCallBack.onItemClicked(listUsers[position]) }
    }

    override fun getItemCount(): Int = listUsers.size
}