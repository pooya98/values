package com.example.values.Spinner

import android.content.Context
import android.content.res.Resources.Theme
import android.util.AttributeSet
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatSpinner

class Spinner_Main : AppCompatSpinner() {
    interface OnSpinnerEventsListener {
        fun onPopupWindowOpened(spinner: Spinner?)
        fun onPopupWindowClosed(spinner: Spinner?)
    }

    private var mListener: OnSpinnerEventsListener? = null
    private var mOpenInitiated = false

    fun CustomSpinner(context: Context?) {
        super(context)
        super.getContext()
    }

    fun CustomSpinner(context: Context, mode: Int) {
        super(context, mode)
    }

    fun CustomSpinner(context: Context, attrs: AttributeSet?) {
        super(context, attrs)
    }

    fun CustomSpinner(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        super(context, attrs, defStyleAttr)
    }

    fun CustomSpinner(context: Context, attrs: AttributeSet?, defStyleAttr: Int, mode: Int) {
        super(context, attrs, defStyleAttr, mode)
    }

    fun CustomSpinner(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        mode: Int,
        popupTheme: Theme?
    ) {
        super(context, attrs, defStyleAttr, mode, popupTheme)
    }

    override fun performClick(): Boolean {
        mOpenInitiated = true
        if (mListener != null) {
            mListener!!.onPopupWindowOpened(this)
        }
        return super.performClick()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasBeenOpened() && hasFocus) {
            performClosedEvent()
        }
    }

    /**
     * Register the listener which will listen for events.
     */
    fun setSpinnerEventsListener(
        onSpinnerEventsListener: OnSpinnerEventsListener?
    ) {
        mListener = onSpinnerEventsListener
    }

    /**
     * Propagate the closed Spinner event to the listener from outside if needed.
     */
    fun performClosedEvent() {
        mOpenInitiated = false
        if (mListener != null) {
            mListener!!.onPopupWindowClosed(this)
        }
    }

    /**
     * A boolean flag indicating that the Spinner triggered an open event.
     *
     * @return true for opened Spinner
     */
    fun hasBeenOpened(): Boolean {
        return mOpenInitiated
    }

}