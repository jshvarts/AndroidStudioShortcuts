package com.jshvarts.androidstudioshortcuts.screenbundle

import android.os.Bundle

/**
 * Concrete Implementation for generating Bundles.
 */
class BundleFactoryImpl : BundleFactory {
    override fun createBundle(): Bundle {
        return Bundle()
    }
}