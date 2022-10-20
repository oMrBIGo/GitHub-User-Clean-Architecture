package org.cn.github.domain.extension

import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import android.view.View
import android.widget.TextView
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

fun String.sha256(): String {
    val digest =
        MessageDigest.getInstance("SHA-256")
    digest.update(this.toByteArray())
    val hash = bytesToHexString(digest.digest())
    return hash?.substring(0, 16)?.toLowerCase() ?: ""
}

fun bytesToHexString(bytes: ByteArray?): String? {
    val sb = StringBuffer()
    if (bytes != null) {
        for (i in bytes.indices) {
            val hex = Integer.toHexString(0xFF and bytes[i].toInt())
            if (hex.length == 1) {
                sb.append('0')
            }
            sb.append(hex)
        }
    }
    return sb.toString()
}

fun String.toDate(
    format: String = "yyyy-MM-dd HH:mm:ss",
    locale: Locale = Locale.getDefault()
): Date {
    return if (!this.isNullOrEmpty()) {
        SimpleDateFormat(format, locale).parse(this)
    } else {
        Calendar.getInstance().time
    }
}

fun String.toTextOrDash(): String {
    return if (this.isNullOrEmpty()) "-" else this
}

fun String.isValidEmail() =
    !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()


fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>, color: Int?) {
    val spannableString = SpannableString(this.text)
    var startIndexOfLink = -1
    for (link in links) {
        val clickableSpan = object : ClickableSpan() {
            override fun updateDrawState(textPaint: TextPaint) {
                // use this to change the link color
                if (color != null) {
                    textPaint.color = color
                } else {
                    textPaint.color = textPaint.linkColor
                }
                // toggle below value to enable/disable
                // the underline shown below the clickable text
                textPaint.isUnderlineText = false
            }

            override fun onClick(view: View) {
                Selection.setSelection((view as TextView).text as Spannable, 0)
                view.invalidate()
                link.second.onClick(view)
            }
        }
        startIndexOfLink = this.text.toString().indexOf(link.first, startIndexOfLink + 1)
//      if(startIndexOfLink == -1) continue // todo if you want to verify your texts contains links text
        spannableString.setSpan(
            clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    this.movementMethod =
        LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}

fun String.splitBySpace(): List<String> {
    return this.split(" ")
}