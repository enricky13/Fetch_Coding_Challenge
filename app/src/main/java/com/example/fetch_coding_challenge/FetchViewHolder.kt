package com.example.fetch_coding_challenge

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetch_coding_challenge.model.ListData

class FetchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var name: TextView? = null
    private var listId: TextView? = null
    private var id: TextView? = null

    init {
        name = itemView.findViewById(R.id.name_tv)
        listId = itemView.findViewById(R.id.listId_tv)
        id = itemView.findViewById(R.id.id_tv)
    }

    fun onBind(info: ListData) {
        itemView.context.let {
            name?.text = it.getString(R.string.name_text, info.name)
            listId?.text = it.getString(R.string.listId_text, info.listId.toString())
            id?.text = it.getString(R.string.Id_text, info.id.toString())
        }
    }
}