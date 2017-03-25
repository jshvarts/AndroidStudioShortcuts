package com.jshvarts.androidstudioshortcuts.app

import android.content.res.Resources
import com.jshvarts.androidstudioshortcuts.screenbundle.BundleFactoryModule
import com.jshvarts.androidstudioshortcuts.screenbundle.ScreenBundleModule
import com.jshvarts.androidstudioshortcuts.repository.RepositoryModule
import dagger.Module
import dagger.Provides

/**
 * Shortcuts Application Dagger Module
 */
@Module(includes = arrayOf(RepositoryModule::class, ScreenBundleModule::class, BundleFactoryModule::class))
class ShortcutsAppModule(private val shortcutsApp: ShortcutsApp) {
    @Provides
    fun provideResources(): Resources = shortcutsApp.resources
}
