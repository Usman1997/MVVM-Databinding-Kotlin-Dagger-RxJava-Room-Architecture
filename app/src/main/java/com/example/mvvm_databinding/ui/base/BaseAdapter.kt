package com.example.mvvm_databinding.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(val list:List<T>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      return onCreateViewHolderBase(parent,viewType)
    }
    abstract fun onCreateViewHolderBase(parent: ViewGroup,viewType: Int):RecyclerView.ViewHolder

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return onBindViewHolderBase(holder,position)
    }
    abstract fun onBindViewHolderBase(holder: RecyclerView.ViewHolder,position: Int)

    override fun getItemCount(): Int {
      return if(list.isNotEmpty()) list.size else 0
    }
}