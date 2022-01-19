package com.oyun.ismekproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oyun.ismekproject.databinding.ActivityHosgeldinBinding
import com.oyun.ismekproject.databinding.ActivityNewLayoutLearnBinding
import com.oyun.ismekproject.databinding.ActivityRegisterBinding
import com.oyun.ismekproject.util.IsmekConstants
import kotlinx.android.synthetic.main.activity_new_layout_learn.*

class NewLayoutLearn : AppCompatActivity() {
    private lateinit var binding: ActivityNewLayoutLearnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewLayoutLearnBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply {
            btn_button1.text = intent.getStringExtra(IsmekConstants.USER_NAME)
        }

        btn_register.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}