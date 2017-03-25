package com.jshvarts.androidstudioshortcuts.app

import android.app.Application
import com.jshvarts.androidstudioshortcuts.BuildConfig
import com.jshvarts.androidstudioshortcuts.repository.RepositoryModule
import com.jshvarts.androidstudioshortcuts.screenbundle.ScreenBundleModule
import timber.log.Timber

/**
 * ShortcutsApp Application
 */
class ShortcutsApp : Application() {

    companion object {
        lateinit var component: ShortcutsAppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerShortcutsAppComponent.builder()
                .repositoryModule(RepositoryModule())
                .screenBundleModule(ScreenBundleModule())
                .shortcutsAppModule(ShortcutsAppModule(this))
                .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}