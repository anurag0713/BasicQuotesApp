package com.example.quotesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context, private val data: ArrayList<QuoteModel>, private val clickListener: OnItemClickListener)
    : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_quote_item, parent, false))
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {

        val item: QuoteModel = data[position]

        holder.quoteText.text = data[position].quote
        holder.author.text = data[position].author

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(item.quote, item.author)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val quoteText : TextView = itemView.findViewById(R.id.quote_text)
        val author: TextView = itemView.findViewById(R.id.author)
    }

    interface OnItemClickListener {
        fun onItemClick(quote: String, author: String)
    }
}