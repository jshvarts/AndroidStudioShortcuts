package com.jshvarts.androidstudioshortcuts.allshortcuts

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.jshvarts.androidstudioshortcuts.R
import com.jshvarts.androidstudioshortcuts.app.ShortcutsApp
import com.jshvarts.androidstudioshortcuts.mvp.BaseViewImpl
import android.support.v7.widget.DividerItemDecoration



/**
 * Conductor Controller displaying all Notes
 */
class AllShortcutsViewImpl(bundle: Bundle) : BaseViewImpl<AllShortcutsView, AllShortcutsPresenter, AllShortcutsViewImpl, AllShortcutsComponent>(bundle), AllShortcutsView {
    @BindView(R.id.all_shortcuts_view_recycler)
    lateinit var shortcutsRecyclerView: RecyclerView

    override fun getComponent(): AllShortcutsComponent = DaggerAllShortcutsComponent.builder()
            .shortcutsAppComponent(ShortcutsApp.component)
            .allShortcutsModule(AllShortcutsModule(this))
            .build()

    override fun getLayoutId(): Int = R.layout.all_shortcuts_view

    override fun setUp() {
        val layoutManager: LinearLayoutManager = LinearLayoutManager(activity)
        shortcutsRecyclerView.layoutManager = layoutManager

        val dividerItemDecoration: DividerItemDecoration = DividerItemDecoration(shortcutsRecyclerView.context, layoutManager.orientation)
        shortcutsRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun setAdapter(adapter: AllShortcutsAdapter) {
        shortcutsRecyclerView.adapter = adapter
    }
}
