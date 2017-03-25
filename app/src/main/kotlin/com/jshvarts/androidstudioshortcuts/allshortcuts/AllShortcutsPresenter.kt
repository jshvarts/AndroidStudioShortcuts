package com.jshvarts.androidstudioshortcuts.allshortcuts
import com.jshvarts.androidstudioshortcuts.mvp.BasePresenter
import com.jshvarts.androidstudioshortcuts.screenbundle.BundleFactory
import com.jshvarts.androidstudioshortcuts.screenbundle.ScreenBundleHelper

/**
 * Presenter for AllShortcuts Screen
 */
class AllShortcutsPresenter(view: AllShortcutsView,
                            private val adapter: AllShortcutsAdapter) : BasePresenter<AllShortcutsView>(view) {

    override fun onViewCreated(restore: Boolean) {
        view.setAdapter(adapter)
        adapter.requestUpdate()
    }

    override fun onViewDestroyed() {
        adapter.cleanup()
    }
}
