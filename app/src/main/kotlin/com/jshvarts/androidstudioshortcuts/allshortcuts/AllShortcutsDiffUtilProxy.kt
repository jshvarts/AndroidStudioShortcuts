package com.jshvarts.androidstudioshortcuts.allshortcuts

import com.jshvarts.androidstudioshortcuts.entities.Shortcut

interface AllShortcutsDiffUtilProxy {
    operator fun invoke(adapter: AllShortcutsAdapter, old: List<Shortcut>, new: List<Shortcut>)
}
