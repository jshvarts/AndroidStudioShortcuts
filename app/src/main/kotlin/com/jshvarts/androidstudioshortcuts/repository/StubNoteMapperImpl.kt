package com.jshvarts.androidstudioshortcuts.repository

import com.jshvarts.androidstudioshortcuts.entities.Shortcut

/**
 * Stub Implementation for DataMapper
 */
class StubShortcutMapperImpl(private val idFactory: IdFactory) : DataMapper<Shortcut>, QueryMapper<Shortcut> {

    private val db = mutableMapOf<String, Shortcut>()

    init {
        getContent().forEach {
            val id = idFactory.createId()
            db.put(id, Shortcut(id, it.key, it.value))
        }
    }

    override fun save(entity: Shortcut) {
        db[entity.id] = entity
    }

    override fun remove(id: String) {
        db.remove(id) ?: throw RepositoryException("Item Does Not Exist")
    }

    override fun query(query: Query<Shortcut>): QueryResponse<Shortcut> {
        return when (query) {
            is Query.SingleObjectByIdQuery<Shortcut> -> getQueryResponse(query)
            is Query.AllObjectsQuery<Shortcut> -> getQueryResponse(query)
        }
    }

    private fun getQueryResponse(query: Query.SingleObjectByIdQuery<Shortcut>): QueryResponse.SingleObjectByIdQueryResponse<Shortcut> {
        return QueryResponse.SingleObjectByIdQueryResponse<Shortcut>(db[query.id] ?: throw RepositoryException("Shortcut does not exist"))
    }

    private fun getQueryResponse(query: Query.AllObjectsQuery<Shortcut>): QueryResponse.AllObjectsQueryResponse<Shortcut> {
        return QueryResponse.AllObjectsQueryResponse(if (query.limit < 0) {
            db.values.toSet()
        } else {
            db.values.take(query.limit).toSet()
        })
    }

    private fun getContent(): Map<String, String> {
        val map = mapOf(
                "Find any command" to " SHFT + CMD + A ",
                "Open class" to " CMD + O ",
                "Open file" to " SHFT + CMD + O ",
                "Create Test" to " OPT + Enter ",
                "Split vertically" to " OPT + CMD + S ",
                "Un-split" to " OPT + CMD + U ",
                "Optimize imports" to " CTRL + OPT + O ",
                "Add unimplemented methods" to " CTRL + I ",
                "Override methods" to " CTRL + O ",
                "Go to implementation" to " OPT + CMD + B ",
                "Close all files" to " CMD + I ",
                "Rebuild project" to " CMD + P ",
                "Run" to " CTRL + R ",
                "Run in Debugger" to " CTRL + D ",
                "Auto-format code" to " OPT + CMD + L ",
                "Select next higher scope" to " OPT + Up ",
                "Select next lower scope" to " OPT + Down ",
                "Find usages" to " CMD + B ",
                "Delete line" to " CMD + Delete ",
                "Duplicate line/selection" to " CMD + D ",
                "Select next occurrence" to " CTRL + G ",
                "Switch to recent files" to " CTRL + Tab "
        )
        return map
    }
}
