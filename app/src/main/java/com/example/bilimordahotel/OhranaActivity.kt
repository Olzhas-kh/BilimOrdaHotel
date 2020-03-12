package com.example.bilimordahotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_ohrana.*

class OhranaActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ohrana)
        mAuth = FirebaseAuth.getInstance()

        btn_ohrana.setOnClickListener {
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
