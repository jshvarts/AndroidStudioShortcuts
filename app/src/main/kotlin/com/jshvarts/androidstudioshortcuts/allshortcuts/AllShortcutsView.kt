package com.jshvarts.androidstudioshortcuts.allshortcuts

import com.jshvarts.androidstudioshortcuts.mvp.BaseView

/**
 * View interface for Controller displaying all notes
 */
interface AllShortcutsView : BaseView {
    fun setAdapter(adapter: AllShortcutsAdapter)
}
