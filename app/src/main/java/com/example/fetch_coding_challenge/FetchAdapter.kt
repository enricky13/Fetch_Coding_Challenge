package com.example.fetch_coding_challenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetch_coding_challenge.model.ListData

class FetchAdapter(private val listData: List<ListData>) : RecyclerView.Adapter<FetchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FetchViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.fetch_itemview, parent, false)
        return FetchViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: FetchViewHolder, position: Int) {
        holder.onBind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}