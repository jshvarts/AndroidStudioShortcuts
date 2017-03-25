package com.jshvarts.androidstudioshortcuts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.TextSwitcher
import butterknife.BindString
import butterknife.BindView
import butterknife.ButterKnife
import com.bluelinelabs.conductor.*
import com.jshvarts.androidstudioshortcuts.allshortcuts.AllShortcutsViewImpl
import com.jshvarts.androidstudioshortcuts.R
import com.jshvarts.androidstudioshortcuts.app.ShortcutsApp
import com.jshvarts.androidstudioshortcuts.screenbundle.BundleFactory
import com.jshvarts.androidstudioshortcuts.screenbundle.ScreenBundleHelper
import javax.inject.Inject

/**
 * Single Activity for Application
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var screenBundleHelper: ScreenBundleHelper

    @Inject
    lateinit var bundleFactory: BundleFactory

    @BindView(R.id.conductor_container)
    lateinit var container: ViewGroup

    @BindView(R.id.main_activity_toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.main_activity_toolbar_title)
    lateinit var toolbarTitle: TextSwitcher

    @BindString(R.string.app_name)
    lateinit var appName: String

    private lateinit var router: Router

    private val changeListener = object : ControllerChangeHandler.ControllerChangeListener {
        override fun onChangeStarted(to: Controller?, from: Controller?, isPush: Boolean, container: ViewGroup, handler: ControllerChangeHandler) {
        }

        override fun onChangeCompleted(to: Controller?, from: Controller?, isPush: Boolean, container: ViewGroup, handler: ControllerChangeHandler) {
            screenBundleHelper.getTitle(to?.args)
                .apply { toolbarTitle.setText(this) }
                .apply { supportActionBar!!.setDisplayHomeAsUpEnabled(!this.equals(appName)) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        ButterKnife.bind(this)
        ShortcutsApp.component.inject(this)
        setSupportActionBar(toolbar)
        router = Conductor.attachRouter(this, container, savedInstanceState)
        router.addChangeListener(changeListener)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(AllShortcutsViewImpl(bundleFactory.createBundle())))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}