package com.jshvarts.androidstudioshortcuts.mvp

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import rx.Observable

/**
 * Base View for MVP Pattern
 */
interface BaseView {

    enum class LifecycleEvent {
        CREATE_VIEW,
        RESTORE_VIEW,
        ACTIVITY_START,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE,
        ACTIVITY_STOP,
        DESTROY_VIEW
    }

    fun lifecycleEvents(): Observable<LifecycleEvent>
    fun displaySnackbar(@StringRes stringResourceId: Int, @BaseTransientBottomBar.Duration length: Int = Snackbar.LENGTH_SHORT)

    /**
     * Implemented by {@link com.bluelinelabs.conductor.Controller}
     */
    fun getArgs(): Bundle
}