package com.jshvarts.androidstudioshortcuts.allshortcuts

import com.jshvarts.androidstudioshortcuts.app.ShortcutsAppComponent
import com.jshvarts.androidstudioshortcuts.di.BaseComponent
import com.jshvarts.androidstudioshortcuts.di.PerScreen
import dagger.Component

@PerScreen
@Component(modules = arrayOf(AllShortcutsModule::class), dependencies = arrayOf(ShortcutsAppComponent::class))
interface AllShortcutsComponent : BaseComponent<AllShortcutsViewImpl>