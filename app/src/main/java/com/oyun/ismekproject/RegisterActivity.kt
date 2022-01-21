package com.oyun.ismekproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.view.isEmpty
import com.oyun.ismekproject.databinding.ActivityRegisterBinding
import com.oyun.ismekproject.util.IsmekConstants
import com.oyun.ismekproject.util.merhabaDe
import kotlinx.android.synthetic.main.activity_new_layout_learn.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        "Murat".merhabaDe()

        binding.apply {
            btnRegister.setOnClickListener {
                if (formValidation()) {
                    val intent = Intent(applicationContext, HosgeldinActivity::class.java)
                    with(intent){
                        putExtra(IsmekConstants.USER_NAME, etName.text.toString())
                        putExtra(IsmekConstants.USER_SURNAME, etsurname.text.toString())
                        putExtra(IsmekConstants.USER_EMAIL, etmail.text.toString())
                    }
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    fun formValidation(): Boolean {
        var isValid = true
        binding.apply {
            if (etName.text.isEmpty())
            {
                Toast.makeText(applicationContext, "Lütfen Adınızı Giriniz",Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (etsurname.text.isEmpty())
            {
                Toast.makeText(applicationContext, "Lütfen Soyadınızı Giriniz",Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (etmail.text.isEmpty())
            {
                Toast.makeText(applicationContext, "Lütfen E-Mail Giriniz",Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (!etmail.text.contains('@'))
            {
                Toast.makeText(applicationContext, "E-mail Formatınız Hatalı",Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (rbGenderBoy.isChecked.not() && rbGenderGirl.isChecked.not())
            {
                Toast.makeText(applicationContext, "Lütfen Cinsiyet Seçiniz",Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (!cbTick.isChecked)
            {
                Toast.makeText(applicationContext, "Lütfen Şartları Kabul Ediniz",Toast.LENGTH_SHORT).show()
                isValid = false
            }
        }

        return isValid
    }

    override fun onResume() {
        super.onResume()
        Log.i("Sonuc","onResume")
        Handler(Looper.getMainLooper()).postDelayed({
            Toast.makeText(this,"3 saniye geçti", Toast.LENGTH_SHORT).show()
            //btn_register.performClick()
        },3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Sonuc","onDestroy")

        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("Sonuc","onPause")

        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("Sonuc","onStop")

        Toast.makeText(this,"onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,"Geri tusuna basıldı", Toast.LENGTH_SHORT).show()
    }


}