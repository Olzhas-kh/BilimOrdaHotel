package com.example.bilimordahotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_admin2.*

class AdminActivity : BaseActivity(0) {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin2)
        setupBottomNavigation()
        mAuth = FirebaseAuth.getInstance()
        btn_home.setOnClickListener {
            mAuth.signOut()
        }
        mAuth.addAuthStateListener {
            if(it.currentUser==null){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}
