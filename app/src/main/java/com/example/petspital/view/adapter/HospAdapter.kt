package com.example.petspital.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.petspital.data.network.Item
import com.example.petspital.databinding.ItemHospBinding
import com.example.petspital.model.hosp.Hosp

class HospAdapter : ListAdapter<Item, HospAdapter.ViewHolder>(diffUtil){
    inner class ViewHolder(private val binding: ItemHospBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.textViewHospTitle.text = item.title
            binding.textViewHospAddress.text = item.address
            binding.textViewHospAppDate.text = item.appDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHospBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.appDate == newItem.appDate
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

        }
    }
}