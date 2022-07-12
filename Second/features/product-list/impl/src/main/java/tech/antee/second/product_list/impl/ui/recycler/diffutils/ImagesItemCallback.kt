package tech.antee.second.product_list.impl.ui.recycler.diffutils

import androidx.recyclerview.widget.DiffUtil

class ImagesItemCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
}
