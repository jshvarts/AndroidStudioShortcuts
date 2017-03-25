package com.jshvarts.androidstudioshortcuts.app

import android.content.res.Resources
import com.jshvarts.androidstudioshortcuts.MainActivity
import com.jshvarts.androidstudioshortcuts.repository.IdFactory
import com.jshvarts.androidstudioshortcuts.repository.Repository
import com.jshvarts.androidstudioshortcuts.screenbundle.BundleFactory
import com.jshvarts.androidstudioshortcuts.screenbundle.ScreenBundleHelper
import dagger.Component
import javax.inject.Singleton

/**
 * Application Component
 */
@Singleton
@Component(modules = arrayOf(ShortcutsAppModule::class))
interface ShortcutsAppComponent {
    fun resources(): Resources

    fun repository(): Repository

    fun screenBundleHelper(): ScreenBundleHelper

    fun bundleFactory(): BundleFactory

    fun idFactory(): IdFactory

    fun inject(mainActivity: MainActivity)
}