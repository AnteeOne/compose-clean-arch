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
    private val sharedViewPool: RecyclerView.RecycledViewPool,
    private val onDetailsClick: (productGuid: String) -> Unit,
    private val onCartButtonClick: (productGuid: String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val TAG = "ProductListViewHolder"

    private val imagesAdapter = ImagesAdapter()
    lateinit var productGuid: String

    init {
        with(binding) {
            itemProductListImages.apply {
                adapter = imagesAdapter
                layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                setRecycledViewPool(sharedViewPool)
            }
            with(itemProductBtnShopCart) {
                setOnClickListener {
                    if (state == ShoppingCartButtonState.NotInCart) {
                        setState(ShoppingCartButtonState.Loading)
                        onCartButtonClick(productGuid)
                    }
                }
            }
            root.setOnClickListener { onDetailsClick(productGuid) }
        }
    }

    fun bind(item: RecyclerItem.Product) = with(binding) {
        Log.d(TAG, "Binded ${item.productItem.name}")
        productGuid = item.productItem.guid

        imagesAdapter.submitList(item.productItem.images)
        itemProductBtnShopCart.setState(
            if (item.productItem.isInCart) ShoppingCartButtonState.InCart else ShoppingCartButtonState.NotInCart
        )
        itemProductListName.text = item.productItem.name
        itemProductPrice.text = item.productItem.price + "₽" // TODO: to string (лень кпц)
    }

    fun bindShoppingCartButtonState(isInCart: Boolean) {
        binding.itemProductBtnShopCart.setState(
            if (isInCart) ShoppingCartButtonState.InCart else ShoppingCartButtonState.NotInCart
        )
    }

    companion object {
        fun from(
            parent: ViewGroup,
            recyclerViewPool: RecyclerView.RecycledViewPool,
            onDetailsClick: (productGuid: String) -> Unit,
            onCartButtonClick: (productGuid: String) -> Unit
        ): ProductListViewHolder {
            val binding = ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ProductListViewHolder(binding, recyclerViewPool, onDetailsClick, onCartButtonClick)
        }
    }
}
