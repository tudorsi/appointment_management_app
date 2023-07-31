package com.example.dynamic_appointment_application.utils.fonts

import android.content.Context
import android.graphics.Typeface
import android.util.Log

object FontCache {

    val MONT_BLACK = "fonts/mont_black.ttf"
    val MONT_MEDIUM = "fonts/mont_medium.ttf"

    private val TAG = FontCache::class.simpleName
    private val fontCache = HashMap<String, Typeface>()

    fun getTypeface(fontName: String, context: Context): Typeface? {
        var typeface = fontCache[fontName]
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, fontName)
            } catch (exception: Exception) {
                Log.e(TAG, "Cannot create type from asset: ${exception.message}")
                return null
            }
            fontCache[fontName] = typeface
        }

        return typeface
    }
}