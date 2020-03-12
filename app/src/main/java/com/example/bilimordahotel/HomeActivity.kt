package com.example.bilimordahotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : BaseActivity(1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigation()
    }
}
