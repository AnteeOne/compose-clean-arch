package tech.antee.second.product_list.impl.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import tech.antee.second.product_list.impl.databinding.ItemProductImageBinding

class ImagesAdapter : ListAdapter<String, ImagesAdapter.ImagesViewHolder>(ImagesItemCallback()) {

    class ImagesViewHolder(private val biding: ItemProductImageBinding) : RecyclerView.ViewHolder(biding.root) {

        fun bind(url: String) {
            biding.itemProductImage.load(url)
        }

        companion object {
            fun from(parent: ViewGroup): ImagesViewHolder {
                val binding = ItemProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ImagesViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder = ImagesViewHolder.from(parent)

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ImagesItemCallback : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
}
