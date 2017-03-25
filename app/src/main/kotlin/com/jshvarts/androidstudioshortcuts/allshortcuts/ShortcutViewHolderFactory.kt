package com.jshvarts.androidstudioshortcuts.allshortcuts

import android.view.ViewGroup

/**
 * Factory Interface which separates ShortcutViewHolder creation code from
 * the Adapter
 */
interface ShortcutViewHolderFactory {
    fun create(parent: ViewGroup): ShortcutViewHolder
}