package tech.antee.second.product_list.impl.ui.recycler.view_holders

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tech.antee.second.product_list.impl.databinding.ItemProductListBinding
import tech.antee.second.product_list.impl.ui.custom_view_components.ShoppingCartButtonState
import tech.antee.second.product_list.impl.ui.recycler.ImagesAdapter
import tech.antee.second.product_list.impl.ui.recycler.models.RecyclerItem

class ProductListViewHolder(
    private val binding: ItemProductListBinding,
    private val onDetailsClick: (productGuid: String) -> Unit,
    private val onCartButtonClick: (productGuid: String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val TAG = "ProductListViewHolder"

    private val imagesAdapter = ImagesAdapter()

    init {
        binding.itemProductListImages.apply {
            adapter = imagesAdapter
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    fun bind(item: RecyclerItem.Product) = with(binding) {
        Log.d(TAG, "Binded ${item.productItem.name}")
        imagesAdapter.submitList(item.productItem.images)
        itemProductBtnShopCart.setState(
            if (item.productItem.isInCart) ShoppingCartButtonState.InCart else ShoppingCartButtonState.NotInCart
        )

        root.setOnClickListener { onDetailsClick(item.productItem.guid) }
        with(itemProductBtnShopCart) {
            setOnClickListener {
                if (state == ShoppingCartButtonState.NotInCart) {
                    setState(ShoppingCartButtonState.Loading)
                    onCartButtonClick(item.productItem.guid)
                }
            }
        }

        itemProductListName.text = item.productItem.name
        itemProductPrice.text = item.productItem.price + "₽" // TODO: to string (лень кпц)
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onDetailsClick: (productGuid: String) -> Unit,
            onCartButtonClick: (productGuid: String) -> Unit
        ): ProductListViewHolder {
            val binding = ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ProductListViewHolder(binding, onDetailsClick, onCartButtonClick)
        }
    }
}
