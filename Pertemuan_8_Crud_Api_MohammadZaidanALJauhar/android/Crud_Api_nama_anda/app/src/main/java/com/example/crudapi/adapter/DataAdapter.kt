package com.example.crudapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudapi.databinding.ItemDataBinding
import com.example.crudapi.model.DataItem

class DataAdapter(private val data: List<DataItem>?, private val click: OnClickItem) :
    RecyclerView.Adapter<DataAdapter.MyHolder>() {

    inner class MyHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(get: DataItem?) {
            binding.tvName.text = get?.staffName
            binding.tvPhone.text = get?.staffHp
            binding.tvAddress.text = get?.staffAlamat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.setOnClickListener { click.clicked(data?.get(position)) }
        // access binding via holder.itemView if needed; include delete button click
    }

    interface OnClickItem {
        fun clicked(item: DataItem?)
        fun delete(item: DataItem?)
    }
}
