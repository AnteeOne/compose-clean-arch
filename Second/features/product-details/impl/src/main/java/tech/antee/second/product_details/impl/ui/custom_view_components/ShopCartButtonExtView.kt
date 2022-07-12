package tech.antee.second.product_details.impl.ui.custom_view_components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import tech.antee.second.product_details.impl.databinding.ItemProductShopCartBinding

class ShopCartButtonExtView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var inCartCount = 0

    val binding = ItemProductShopCartBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        gravity = 0x01
        updateButtons()
    }

    fun setInCartCount(count: Int) {
        inCartCount = count
        updateButtons()
        updateTextCounter()
    }

    fun setOnClickListener(onClick: (ShopCartBtnClickType) -> Unit) = with(binding) {
        itemProductShopCartBtnInitial.setOnClickListener { onClick(ShopCartBtnClickType.OnAdd) }
        itemProductShopCartBtnAdd.setOnClickListener { onClick(ShopCartBtnClickType.OnAdd) }
        itemProductShopCartBtnRemove.setOnClickListener { onClick(ShopCartBtnClickType.OnRemove) }
    }

    private fun updateButtons() = with(binding) {
        when (inCartCount) {
            0 -> {
                itemProductShopCartBtns.visibility = View.GONE
                itemProductShopCartBtnInitial.visibility = View.VISIBLE
            }
            else -> {
                itemProductShopCartBtns.visibility = View.VISIBLE
                itemProductShopCartBtnInitial.visibility = View.GONE
            }
        }
    }

    private fun updateTextCounter() {
        binding.itemProductShopCartCount.text = inCartCount.toString()
    }
}

enum class ShopCartBtnClickType {
    OnAdd,
    OnRemove
}
