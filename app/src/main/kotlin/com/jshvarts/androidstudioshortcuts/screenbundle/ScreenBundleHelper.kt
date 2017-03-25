package com.jshvarts.androidstudioshortcuts.screenbundle

import android.os.Bundle
import android.support.annotation.StringRes

/**
 * Factory Interface for construction of screen bundles
 */
interface ScreenBundleHelper {
    fun setTitle(bundle: Bundle, @StringRes screenTitleRes: Int)
    fun setTitle(bundle: Bundle, screenTitle: String)
    fun getTitle(bundle: Bundle?): String
}