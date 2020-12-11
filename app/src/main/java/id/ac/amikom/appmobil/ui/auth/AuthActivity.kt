package id.ac.amikom.appmobil.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.ac.amikom.appmobil.R
import id.ac.amikom.appmobil.data.model.AuthUser
import id.ac.amikom.appmobil.databinding.ActivityAuthBinding
import id.ac.amikom.appmobil.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSuccess(user : AuthUser?){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}