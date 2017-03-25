package com.jshvarts.androidstudioshortcuts.allshortcuts

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.jshvarts.androidstudioshortcuts.entities.Shortcut
import rx.Subscription

/**
 * Adapter which displays all shortcuts in the repository
 */
class AllShortcutsAdapter(val model: AllShortcutsModel,
                          val view: AllShortcutsView,
                          val allShortcutsDiffUtilProxy: AllShortcutsDiffUtilProxy,
                          val shortcutsViewHolderFactory: ShortcutViewHolderFactory) : RecyclerView.Adapter<ShortcutViewHolder>() {

    private var shortcuts = listOf<Shortcut>()

    private val subscribeFn = { newShortcuts: Set<Shortcut> ->
        val oldShortcuts = shortcuts
        shortcuts = newShortcuts.toList()
        allShortcutsDiffUtilProxy(this, oldShortcuts, shortcuts)
    }

    private var dataSubscription: Subscription? = null

    fun requestUpdate() {
        dataSubscription?.unsubscribe()
        dataSubscription = model.getAllShortcuts().subscribe(subscribeFn)
    }

    fun cleanup() {
        dataSubscription?.unsubscribe()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortcutViewHolder {
        val holder = shortcutsViewHolderFactory.create(parent)
        return holder
    }

    override fun onBindViewHolder(holder: ShortcutViewHolder?, position: Int) {
        val shortcut = shortcuts[position]
        holder?.setTitle(shortcut.title)
        holder?.setKeys(shortcut.keys)
    }

    override fun getItemCount() = shortcuts.size
}
