package com.jshvarts.androidstudioshortcuts.allshortcuts

import com.jshvarts.androidstudioshortcuts.entities.Shortcut
import rx.Single


/**
 * Model interface for Presenter displaying all shortcuts
 */
interface AllShortcutsModel {
    fun getAllShortcuts(): Single<Set<Shortcut>>
}