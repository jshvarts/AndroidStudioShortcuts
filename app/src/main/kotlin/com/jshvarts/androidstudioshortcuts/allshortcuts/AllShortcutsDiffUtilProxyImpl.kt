package com.jshvarts.androidstudioshortcuts.allshortcuts

import android.support.v7.util.DiffUtil
import com.jshvarts.androidstudioshortcuts.entities.Shortcut

/**
 * Concrete Implementation for Diff Util
 */
class AllShortcutsDiffUtilProxyImpl : AllShortcutsDiffUtilProxy {

    class AllShortcutsDiffUtilCallback(private val old: List<Shortcut>,
                                   private val new: List<Shortcut>) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old.getOrNull(oldItemPosition)?.id?.equals(new.getOrNull(newItemPosition)?.id)?:false

        override fun getOldListSize() = old.size

        override fun getNewListSize() = new.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old.getOrNull(oldItemPosition)?.equals(new.getOrNull(newItemPosition))?:false

    }

    override fun invoke(adapter: AllShortcutsAdapter, old: List<Shortcut>, new: List<Shortcut>) {
        DiffUtil.calculateDiff(AllShortcutsDiffUtilCallback(old, new)).dispatchUpdatesTo(adapter)
    }
}