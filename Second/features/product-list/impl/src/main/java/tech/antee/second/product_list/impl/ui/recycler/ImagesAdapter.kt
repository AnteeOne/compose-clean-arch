package tech.antee.second.product_list.impl.ui.recycler

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import tech.antee.second.product_list.impl.ui.recycler.diffutils.ImagesItemCallback
import tech.antee.second.product_list.impl.ui.recycler.view_holders.ImagesViewHolder

class ImagesAdapter : ListAdapter<String, ImagesViewHolder>(ImagesItemCallback()) {

    private val TAG = "ImagesAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        Log.d(TAG, "Created ImagesViewHolder")
        return ImagesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
