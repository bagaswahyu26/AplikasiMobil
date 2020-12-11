    package id.ac.amikom.appmobil.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.ac.amikom.appmobil.R
import id.ac.amikom.appmobil.databinding.ActivityAuthBinding
import id.ac.amikom.appmobil.databinding.ActivityMainBinding
import id.ac.amikom.appmobil.ui.auth.AppmobilAuth
import id.ac.amikom.appmobil.ui.auth.AuthActivity

    class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            AppmobilAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}