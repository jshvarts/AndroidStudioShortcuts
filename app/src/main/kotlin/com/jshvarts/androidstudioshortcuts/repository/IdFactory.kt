package com.jshvarts.androidstudioshortcuts.repository

/**
 * Interface for generating unique ids
 */
interface IdFactory {
    fun createId(): String
}