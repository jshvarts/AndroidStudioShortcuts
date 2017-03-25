package com.jshvarts.androidstudioshortcuts.allshortcuts

import com.jshvarts.androidstudioshortcuts.di.PerScreen
import com.jshvarts.androidstudioshortcuts.repository.Repository
import dagger.Module
import dagger.Provides

/**
 * AllShortcuts Dagger Module
 */
@Module
class AllShortcutsModule(private val allShortcutsView: AllShortcutsView) {
    @Provides
    @PerScreen
    fun provideModel(repository: Repository): AllShortcutsModel = AllShortcutsModelImpl(repository)

    @Provides
    @PerScreen
    fun provideAllShortcutsDiffUtilProxy(): AllShortcutsDiffUtilProxy = AllShortcutsDiffUtilProxyImpl()

    @Provides
    @PerScreen
    fun provideAdapter(model: AllShortcutsModel, diffUtilProxy: AllShortcutsDiffUtilProxy): AllShortcutsAdapter
        = AllShortcutsAdapter(model, allShortcutsView, diffUtilProxy, ShortcutViewHolder)

    @Provides
    @PerScreen
    fun providePresenter(adapter: AllShortcutsAdapter): AllShortcutsPresenter
            = AllShortcutsPresenter(allShortcutsView, adapter)
}
