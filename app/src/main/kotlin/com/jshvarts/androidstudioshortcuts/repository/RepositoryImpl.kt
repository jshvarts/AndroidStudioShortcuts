package com.jshvarts.androidstudioshortcuts.repository

import com.jshvarts.androidstudioshortcuts.entities.Shortcut
import rx.Single

/**
 * Generic Repository that wraps mapper results into Rx Singles
 */
class RepositoryImpl(private val noteDataMapper: DataMapper<Shortcut>,
                     private val noteQueryMapper: QueryMapper<Shortcut>) : Repository {

    override fun getAllShortcuts(): Single<Set<Shortcut>> = Single.fromCallable {
        val response = noteQueryMapper.query(Query.AllObjectsQuery())
        when (response) {
            is QueryResponse.AllObjectsQueryResponse -> response.items
            else -> throw RepositoryException("Improper Response Type")
        }
    }

    override fun getShortcutById(id: String): Single<Shortcut> = Single.fromCallable {
        val response = noteQueryMapper.query(Query.SingleObjectByIdQuery(id))
        when (response) {
            is QueryResponse.SingleObjectByIdQueryResponse -> response.item
            else -> throw RepositoryException("Improper Response Type")
        }
    }

    override fun saveShortcut(note: Shortcut): Single<Unit> = Single.fromCallable {
        noteDataMapper.save(note)
    }

    override fun deleteShortcut(id: String): Single<Unit> = Single.fromCallable {
        noteDataMapper.remove(id)
    }
}