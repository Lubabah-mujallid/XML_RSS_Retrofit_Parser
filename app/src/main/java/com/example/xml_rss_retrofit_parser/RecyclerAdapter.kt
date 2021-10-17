package com.example.xml_rss_retrofit_parser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_rss_retrofit_parser.channel.Rss
import com.example.xml_rss_retrofit_parser.channel.item.Item
import kotlinx.android.synthetic.main.recycler_layout.view.*

class RecyclerAdapter (val context: Context, val messages: ArrayList<Item>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return RecyclerAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val message = messages[position]
        holder.itemView.apply {
            tvRecyclerTitle.text = message.title.toString().capitalize()
            //tvRecyclerQ.text = message.description.toString()
        }
    }

    override fun getItemCount(): Int = messages.size


}