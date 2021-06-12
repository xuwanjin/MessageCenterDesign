package com.xuwanjin.messagecenterlib

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.xuwanjin.messagecenterlib.fragment.BaseFragmentPageAdapter
import com.xuwanjin.messagecenterlib.fragment.DeviceMessageFragment
import com.xuwanjin.messagecenterlib.fragment.PushMessageFragment
import com.xuwanjin.messagecenterlib.fragment.SharingFragment

class MessageCenterActivity : AppCompatActivity() {
    private lateinit var mMessageTabLayout: TabLayout
    private lateinit var vpMessageContent: ViewPager2
    private lateinit var mFragmentList: MutableList<Fragment>

    companion object {
        const val MAX_FIX_TAB_ITEM = 4
    }

    protected var titleList = mutableListOf<String>().apply {
        add("设备通知")
        add("推送消息")
        add("分享")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_center)
        mMessageTabLayout = findViewById(R.id.message_tab_layout_container)
        vpMessageContent = findViewById(R.id.vp_message_content)
        initFragmentList()
        vpMessageContent.isUserInputEnabled = true
        vpMessageContent.adapter =
            BaseFragmentPageAdapter(supportFragmentManager, lifecycle, mFragmentList)
        attachTabLayoutAndViewPager2()
    }

    private fun initFragmentList() {
        mFragmentList = mutableListOf<Fragment>().apply {
            add(DeviceMessageFragment())
            add(PushMessageFragment())
            add(SharingFragment())
        }
        Log.d("Matthew", "onCreate: fragmentList.size = ${mFragmentList.size}")

        if (mFragmentList.size > MAX_FIX_TAB_ITEM) {
            mMessageTabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        }
    }


    private fun attachTabLayoutAndViewPager2() {
        Log.d("Matthew", "attachTabLayoutAndViewPager2: ")
        TabLayoutMediator(
            mMessageTabLayout,
            vpMessageContent
        ) { tab, position ->
            tab.text = titleList[position]
        }.attach()
    }
}