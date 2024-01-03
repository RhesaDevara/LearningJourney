package com.reshproject.learningjourney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListLessonAdapter(private val listIcon: ArrayList<Lesson>): RecyclerView.Adapter<ListLessonAdapter.ListViewHolder>()  {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listIcon.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name) = listIcon[position]
        holder.tvName.text = name
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listIcon[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Lesson)
    }

}
