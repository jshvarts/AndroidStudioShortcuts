package com.jshvarts.androidstudioshortcuts.repository

import com.jshvarts.androidstudioshortcuts.entities.Shortcut
import rx.Single

/**
 * Repository Interface.  A Repository represents the single source of
 * truth for all entities.  Entities should not be passed between screens.
 * Instead their ID should be passed, and queried from the Single source of
 * Truth.
 */
interface Repository {
    /**
     * Returns all the shortcuts currently in the repository
     */
    fun getAllShortcuts(): Single<Set<Shortcut>>

    /**
     * Gets the shortcut with id from the repository
     */
    fun getShortcutById(id: String): Single<Shortcut>

    /**
     * Saves shortcut to the repository
     */
    fun saveShortcut(note: Shortcut): Single<Unit>

    /**
     * Removes shortcut from the repository
     */
    fun deleteShortcut(id: String): Single<Unit>
}