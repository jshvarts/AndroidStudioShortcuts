package com.jshvarts.androidstudioshortcuts.repository

import com.jshvarts.androidstudioshortcuts.entities.Shortcut
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger Module for Repository Dependencies
 */
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideIdFactory(): IdFactory {
        return IdFactoryImpl()
    }

    @Provides
    @Singleton
    fun provideDataMapper(idFactory: IdFactory): DataMapper<Shortcut> {
        return StubShortcutMapperImpl(idFactory)
    }

    @Provides
    fun provideQueryMapper(dataMapper: DataMapper<Shortcut>): QueryMapper<Shortcut> {
        return dataMapper as StubShortcutMapperImpl
    }

    @Provides
    @Singleton
    fun provideRepository(noteDataMapper: DataMapper<Shortcut>,
                          noteQueryMapper: QueryMapper<Shortcut>): Repository {
        return RepositoryImpl(noteDataMapper, noteQueryMapper)
    }
}