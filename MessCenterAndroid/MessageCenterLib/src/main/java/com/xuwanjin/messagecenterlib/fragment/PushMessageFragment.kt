package com.xuwanjin.messagecenterlib.fragment

import android.os.Bundle
import android.widget.TextView
import com.xuwanjin.messagecenterlib.R
import com.xuwanjin.messagecenterlib.fragment.BaseFragment

class PushMessageFragment: BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        fragmentView.findViewById<TextView>(R.id.fragment_text).text = "Push Message"
    }
}