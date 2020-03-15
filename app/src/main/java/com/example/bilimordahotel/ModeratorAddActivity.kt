package com.example.bilimordahotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ModeratorAddActivity : BaseModeratorActivity(1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moderator_add)
        ModeratorBottomNavigation()
    }
}
