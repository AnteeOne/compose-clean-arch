package tech.antee.second.product_list.impl.ui.recycler.view_holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import tech.antee.second.product_list.impl.databinding.ItemProductImageBinding

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