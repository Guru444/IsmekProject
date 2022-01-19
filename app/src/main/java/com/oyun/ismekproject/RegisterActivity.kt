package com.oyun.ismekproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_new_layout_learn.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {
            if (formValidation()) {
                Toast.makeText(this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun formValidation(): Boolean {
        var isValid = true

        if (etName.text.isEmpty())
        {
            Toast.makeText(this, "Lütfen Adınızı Giriniz",Toast.LENGTH_SHORT).show()
            isValid = false
        }
        if (etsurname.text.isEmpty())
        {
            Toast.makeText(this, "Lütfen Soyadınızı Giriniz",Toast.LENGTH_SHORT).show()
            isValid = false
        }
        if (etmail.text.isEmpty())
        {
            Toast.makeText(this, "Lütfen E-Mail Giriniz",Toast.LENGTH_SHORT).show()
            isValid = false
        }
        if (!etmail.text.contains('@'))
        {
            Toast.makeText(this, "E-mail Formatınız Hatalı",Toast.LENGTH_SHORT).show()
            isValid = false
        }
        if (rbGenderBoy.isChecked.not() || rbGenderGirl.isChecked.not())
        {
            Toast.makeText(this, "Lütfen Cinsiyet Seçiniz",Toast.LENGTH_SHORT).show()
            isValid = false
        }
        if (!cbTick.isChecked)
        {
            Toast.makeText(this, "Lütfen Şartları Kabul Ediniz",Toast.LENGTH_SHORT).show()
            isValid = false
        }

        return isValid
    }

}