package com.jshvarts.androidstudioshortcuts.allshortcuts

import com.jshvarts.androidstudioshortcuts.repository.Repository

/**
 * Implementation for All Notes model
 */
class AllShortcutsModelImpl(private val repository: Repository) : AllShortcutsModel {
    override fun getAllShortcuts() = repository.getAllShortcuts()
 }