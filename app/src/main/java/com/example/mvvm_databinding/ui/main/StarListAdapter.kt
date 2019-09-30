package com.example.mvvm_databinding.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_databinding.R
import com.example.mvvm_databinding.databinding.ListStarItemBinding
import com.example.mvvm_databinding.model.Repo
import com.example.mvvm_databinding.ui.base.BaseAdapter


class StarListAdapter(list:List<Repo>) :BaseAdapter<Repo>(list){
    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_star_item, parent, false)
        return ListStarViewHolder(view)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ListStarViewHolder).binding
        val repo = list[position]
        binding?.repo = repo
    }

    class ListStarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ListStarItemBinding? = DataBindingUtil.bind(view)
    }
}