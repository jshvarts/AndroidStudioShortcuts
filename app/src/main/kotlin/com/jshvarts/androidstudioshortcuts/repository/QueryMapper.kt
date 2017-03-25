package com.jshvarts.androidstudioshortcuts.repository

/**
 * Interface for Accessing Data
 */
interface QueryMapper<T> {
    fun query(query: Query<T>): QueryResponse<T>
}