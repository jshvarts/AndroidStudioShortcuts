package com.jshvarts.androidstudioshortcuts.allshortcuts

import android.support.v7.widget.RecyclerView
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.jshvarts.androidstudioshortcuts.R

/**
 * View of a Shortcut in the AllShortcutsAdapter
 */
class ShortcutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object : ShortcutViewHolderFactory {
        override fun create(parent: ViewGroup): ShortcutViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.all_shortcuts_view_adapter_item, parent, false)
            return ShortcutViewHolder(view)
        }
    }

    @BindView(android.R.id.text1)
    lateinit var titleView: TextView

    @BindView(android.R.id.text2)
    lateinit var keysView: TextView

    init {
        ButterKnife.bind(this, itemView)
        titleView.maxLines = 1
        titleView.ellipsize = TextUtils.TruncateAt.END
        keysView.maxLines = 1
        keysView.ellipsize = TextUtils.TruncateAt.END
    }

    fun setTitle(title: String) {
        titleView.text = title
    }

    fun setKeys(keys: String) {
        keysView.text = keys
        formatKeys()
    }

    private fun formatKeys() {
        val spannable = SpannableString(keysView.text)
        spannable.split("+").forEach {
            spannable.setSpan(BackgroundColorSpan(R.color.colorShortcutKeysBackground),
                    spannable.indexOf(it), spannable.indexOf(it)+it.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            TextUtils.concat(spannable, "+")
        }
        keysView.text = spannable
    }
}
