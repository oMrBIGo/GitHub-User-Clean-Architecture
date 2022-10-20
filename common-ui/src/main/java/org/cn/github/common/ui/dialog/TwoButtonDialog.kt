package org.cn.github.common.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.Window
import android.view.WindowManager
import org.cn.common.databinding.DialogTwoButtonBinding

class TwoButtonDialog(
    private val mContext: Context,
    private val drawable: Drawable? = null,
    private val title: String? = null,
    private val detail: String? = null,
    private val buttonText: String? = null,
    private val mOnClickApplyListener: OnClickApplyListener? = null,
    private val isHideCancelButtonText: Boolean = false
) : Dialog(mContext){

    private lateinit var mBinding: DialogTwoButtonBinding

    interface OnClickApplyListener {
        fun onClickApplyListener()
    }

    init {
        window!!.requestFeature(Window.FEATURE_NO_TITLE)
        mBinding = DialogTwoButtonBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setCancelable(false)
        setViewContent()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        mBinding.btnCancelTwoButtonDialog.setOnClickListener {
            dismiss()
        }
        mBinding.btnConfirmTwoButtonDialog.setOnClickListener {
            mOnClickApplyListener?.onClickApplyListener()
            dismiss()
        }
    }

    private fun setViewContent() {
        drawable?.let {
            mBinding.imvTwoButtonDialog.setImageDrawable(drawable)
        }
        title?.let {
            mBinding.txvTitleTwoButtonDialog.text = title
        }
        detail?.let {
            mBinding.txvDetailTwoButtonDialog.text = detail
        }
        buttonText?.let {
            mBinding.btnConfirmTwoButtonDialog.text = buttonText
        }

        mBinding.btnCancelTwoButtonDialog.visibility =
            if (isHideCancelButtonText) View.GONE else View.VISIBLE
    }
}