package com.oyun.ismekproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.oyun.ismekproject.databinding.ActivityHosgeldinBinding
import com.oyun.ismekproject.util.IsmekConstants

class HosgeldinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHosgeldinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHosgeldinBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            tvUserName.text = intent.getStringExtra(IsmekConstants.USER_NAME).toString()
            tvUserSurname.text = intent.getStringExtra(IsmekConstants.USER_SURNAME).toString()
            tvUserMail.text = intent.getStringExtra(IsmekConstants.USER_EMAIL).toString()

            btnBacktoMain.setOnClickListener {
                val intent = Intent(applicationContext,NewLayoutLearn::class.java)
                    intent.putExtra(IsmekConstants.USER_NAME, tvUserName.text)
                    intent.putExtra(IsmekConstants.USER_SURNAME, tvUserSurname.text)

                startActivity(intent)
            }
        }
    }
}