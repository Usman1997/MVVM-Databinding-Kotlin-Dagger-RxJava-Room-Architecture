package com.example.mvvm_databinding.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_databinding.model.Repo

object StarListBinding {
    @JvmStatic
    @BindingAdapter("load_repos")
    fun loadUsers(recyclerView: RecyclerView, repos: List<Repo>?) {
        recyclerView.adapter = if (repos != null) StarListAdapter(repos) else StarListAdapter(emptyList())
    }
}