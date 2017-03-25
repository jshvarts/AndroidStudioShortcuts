package com.jshvarts.androidstudioshortcuts.screenbundle

import android.content.res.Resources
import android.os.Bundle
import com.jshvarts.androidstudioshortcuts.R

/**
 * Implementation for ScreenBundleHelper
 */
class ScreenBundleHelperImpl(private val resources: Resources) : ScreenBundleHelper {
    companion object {
        private val TITLE = "screenBundleHelper.title"
    }

    private val appName: String
        get() = resources.getString(R.string.app_name)

    override fun setTitle(bundle: Bundle, screenTitleRes: Int) {
        bundle.putString(TITLE, resources.getString(screenTitleRes))
    }

    override fun setTitle(bundle: Bundle, screenTitle: String) {
        bundle.putString(TITLE, screenTitle)
    }

    override fun getTitle(bundle: Bundle?): String
            = bundle?.getString(TITLE, appName)?:appName
}