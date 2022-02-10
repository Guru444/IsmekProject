package com.oyun.ismekproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_IsmekProject)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        var kullaniciAdi: String = intent.getStringExtra("adi").toString()
        var userPosition: Int = intent.getIntExtra("position",-1)
        tv_welcome.text = getString(R.string.welcome_text, kullaniciAdi, "Lütfen bilgilerini gir")

        Hawk.get<String>(kullaniciAdi)?.let {
            edt_password.setText(it)
        }

        Hawk.get<Boolean>(userPosition.toString())?.let {
            cb_dont_remember.isChecked = it
        }


        btn_save.setOnClickListener {
            if (cb_dont_remember.isChecked){
                Hawk.put(userPosition.toString(), true)
                Hawk.put(kullaniciAdi, edt_password.text.toString())
            }else{
                Hawk.put(userPosition.toString(), false)
                Hawk.delete(kullaniciAdi)
            }
        }
    }
}