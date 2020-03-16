package com.example.bilimordahotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_moderator_add.*

class ModeratorAddActivity : BaseModeratorActivity(1) {
    private  lateinit  var databaseReference : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moderator_add)
        ModeratorBottomNavigation()
        databaseReference = FirebaseDatabase.getInstance().reference

        btn_add.setOnClickListener {
            val key = databaseReference.child("humans").push().key
            val game = Users(
                name = full_name_input.text.toString(),
                phone = phone_number_input.text.toString().toLong(),
                city = city_input.text.toString(),
                iin = iin_input.text.toString().toLong()
            )
            key?.let {
                game.uuid = key
                databaseReference.child("humans").child(key).setValue(game)
            }


        }
    }
}
