package com.example.bilimordahotel

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_moderator.*

open class BaseModeratorActivity(val narNumber: Int): AppCompatActivity() {
    private val TAG = "BaseModeratorActivity"
    fun ModeratorBottomNavigation() {
        moderator_navigation_view.setIconSize(29f, 29f)
        moderator_navigation_view.setTextVisibility(false)
        moderator_navigation_view.enableItemShiftingMode(false)
        moderator_navigation_view.enableShiftingMode(false)
        moderator_navigation_view.enableAnimation(false)
        for (i in 0 until moderator_navigation_view.menu.size()) {
            moderator_navigation_view.setIconTintList(i, null)
        }
        moderator_navigation_view.setOnNavigationItemSelectedListener {
            val nextActivity =
                when (it.itemId) {
                    R.id.nav_item_add_guest -> ModeratorAddActivity::class.java
                    R.id.nav_item_list -> ModeratorActivity::class.java
                    else -> {
                        Log.e(TAG, "unknown nav item clicked $it")
                        null
                    }
                }
            if (nextActivity != null) {
                val intent = Intent(this, nextActivity)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
                overridePendingTransition(0, 0)
                true
            } else {
                false
            }
        }
        moderator_navigation_view.menu.getItem(narNumber).isChecked = true

    }
}