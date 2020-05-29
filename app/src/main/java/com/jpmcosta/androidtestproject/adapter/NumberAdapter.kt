package com.jpmcosta.androidtestproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jpmcosta.androidtestproject.R
import com.jpmcosta.androidtestproject.adapter.NumberAdapter.NumberHolder

class NumberAdapter(count: Int) : RecyclerView.Adapter<NumberHolder>() {

    var count: Int = count
        set(count) {
            var previousCount = field
            if (previousCount != count) {
                field = count
                if (count < previousCount) {
                    do {
                        val index = --previousCount
                        notifyItemRemoved(index)
                    } while (count < previousCount)
                } else {
                    notifyDataSetChanged()
                }
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder =
            NumberHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_number, parent, false))

    override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        holder.bind(number = position)
    }

    override fun getItemCount(): Int = count


    class NumberHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(number: Int) {
            (itemView as TextView).text = number.toString()
        }
    }
}