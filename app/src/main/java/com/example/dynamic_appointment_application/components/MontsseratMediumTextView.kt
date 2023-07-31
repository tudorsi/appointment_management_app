package com.example.dynamic_appointment_application.components

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.dynamic_appointment_application.utils.fonts.FontCache

class MontsseratMediumTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): AppCompatTextView(context, attrs, defStyleAttr) {
    override fun setTypeface(tf: Typeface?) {
        val customFont = FontCache.getTypeface(FontCache.MONT_MEDIUM, context)
        super.setTypeface(customFont)
    }
}