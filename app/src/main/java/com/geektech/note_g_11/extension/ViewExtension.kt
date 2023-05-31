package com.geektech.note_g_11.extension

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.visibility(isVisible: Boolean) {
    if (isVisible) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}

fun Fragment.showToast(msg: String) {
    Toast.makeText(this.requireContext(), msg, Toast.LENGTH_SHORT).show()

}

fun Fragment.showToast(id: Int) {
    Toast.makeText(this.requireContext(), this.getString(id), Toast.LENGTH_SHORT).show()

}