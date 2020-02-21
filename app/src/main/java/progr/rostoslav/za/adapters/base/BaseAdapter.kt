package com.example.easyreader3.presentation.adapters.base

import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseAdapter<P> : RecyclerView.Adapter<BaseViewHolder<P>>() {
    protected var items: MutableList<P> = ArrayList()

    var hasItems = false

 open fun setList(data: List<P>) {
        items.clear()
        items.addAll(data)
        hasItems = true
        notifyDataSetChanged()
    }

    fun addItem(item: P, position: Int = items.size ) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun addItems(itemsForAdd: List<P>, position: Int = 0) {
        items.addAll(position, itemsForAdd)
        notifyItemRangeInserted(position, itemsForAdd.count())
    }

    fun updateItem(position: Int, newItem: P) {
        items[position] = newItem
        notifyItemChanged(position)
    }

    fun deleteItem(item: P) {
        val position = items.indexOf(item)
        items.removeAt(position)
        notifyItemRemoved(position)
    }



    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: BaseViewHolder<P>, position: Int) {
        holder.bind(items[position])
    }
}