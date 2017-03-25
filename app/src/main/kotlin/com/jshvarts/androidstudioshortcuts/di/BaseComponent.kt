package com.jshvarts.androidstudioshortcuts.di

import com.jshvarts.androidstudioshortcuts.mvp.BaseViewImpl

/**
 * Base Component which injects an InjectionTarget
 */
interface BaseComponent<in B : BaseViewImpl<*, *, *, *>> {
    fun inject(controller: B)
}