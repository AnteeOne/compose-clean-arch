package tech.antee.second.product_list.impl.ui.custom_view_components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import tech.antee.second.product_list.impl.R
import tech.antee.second.product_list.impl.ui.custom_view_components.ShoppingCartButtonState.*

class ShoppingCartButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val rect: RectF = RectF(0f, 0f, 0f, 0f)

    private var bgColor: Int = Color.BLUE
    private var bgInCartColor: Int = Color.GREEN
    private var textColor: Int = Color.WHITE

    var state: ShoppingCartButtonState = NotInCart
        private set

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 35.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.ShoppingCartButtonView, 0, 0).apply {
            state = mapIdToState(getInt(R.styleable.ShoppingCartButtonView_uiState, 0))
        }
        isClickable = true
        isFocusable = true
    }

    fun setState(btnState: ShoppingCartButtonState) {
        state = btnState
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rect.set(0f, 0f, w.toFloat(), h.toFloat())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        with(paint) {
            color = when (state) {
                InCart -> bgInCartColor
                else -> bgColor
            }
            canvas.drawRect(rect, paint)

            when (state) {
                NotInCart -> canvas.drawTextInBtn("Add to cart")
                Loading -> canvas.drawTextInBtn("Loading...")
                InCart -> canvas.drawTextInBtn("In the cart")
            }
        }
    }

    private fun Canvas.drawTextInBtn(text: String) {
        paint.color = textColor
        drawText(text, (width / 2).toFloat(), ((height + 30) / 2).toFloat(), paint)
    }

    private fun mapIdToState(stateId: Int): ShoppingCartButtonState = when (stateId) {
        0 -> NotInCart
        1 -> Loading
        2 -> InCart
        else -> error("Unknown state id")
    }
}

enum class ShoppingCartButtonState {
    NotInCart,
    Loading,
    InCart
}
