package com.oyun.ismekproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val sayi = 5
        var sayi2: Int = 5
        val sayi3 = 5
        val sayi4: Int = 5
        var isim: String = "Murat"
        var soyisim = "Karabulut"

        //Dört işlem
        dortIslem()
        //String işlemleri
        stringIslemleri()
        //İf else
        ifElse()
        //When
        whenProcess()
        //Döngü
        loopProcess()

        Log.i("Sonuc fun toplama", toplama(5,3))
    }

    fun dortIslem(){
        var birinciSayi = 5
        var ikinciSayi = 10
        var toplam = birinciSayi + ikinciSayi
        var cikarma = birinciSayi - ikinciSayi
        var bolme = birinciSayi / ikinciSayi
        var carpma = birinciSayi * ikinciSayi
    }
    fun stringIslemleri(){
        var adim = "Murat Karabulut"
        Log.i("Sonuc",adim)
        Log.i("Sonuc upperCase",adim.uppercase())
        Log.i("Sonuc lowerCase",adim.lowercase())
        Log.i("Sonuc plus",adim.plus(" Derste"))
        Log.i("Sonuc subString",adim.substring(6,13))
        Log.i("Sonuc index", adim.get(3).toString())

        val isimListesi = adim.split(" ").toTypedArray()
        val ad = isimListesi.get(0).substring(0,1)
        val soyad = isimListesi.get(1).substring(0,1)
        Log.i("Sonuc Adım Soyadım",ad + " - "+ soyad + "***")
        //M*** - K***
        Toast.makeText(this,"Merhaba", Toast.LENGTH_SHORT).show()

    }
    fun ifElse(){
        val number = 5
        val number2 = 2
        if (number > number2){
            Log.i("Sonuc kontrol", "Number, Number2den büyüktür")
        }else if (number == number2){
            Log.i("Sonuc kontrol", "Number, Number2den eşittir")
        }else{
            Log.i("Sonuc kontrol", "Number, Number2den küçüktür")
        }
    }
    fun whenProcess(){
        val havaYagisli = "Yagmurlu"
        when(havaYagisli){
            "Yagmursuz"->{
                Log.i("Sonuc yağmursuz","Yağmursuz")
            }
            "Yagmurlu"->{
                Log.i("Sonuc yağmurlu","Yağmurlu")
            }
            else->{
                Log.i("Sonuc ne bileyim ben","Bilmem")
            }
        }
    }
    fun loopProcess(){
        for (x in 0..5){
            for(y in 0..x){
                print("*")
            }
            println()
        }
        var kelime: String = ""

        //Casting
        val sayi5 = "10"
        var sayiInt = sayi5.toInt() // as Int

        var liste: ArrayList<Any> = arrayListOf()
        liste.add(3) //int
        liste.add("Murat") //string
        liste.add(12.4) // double
        liste.add(12.4F) // float
        liste.add('c') // char

        liste.forEach {

        }

        /*for (x in liste.indices){
            liste.get(x)
        }*/

    }

    fun toplama(sayi1: Int, sayi2: Int) : String{
        return (sayi1 + sayi2).toString()
    }
}


/*liste.remove(0) // 0. elemanı siler
       liste.get(4) // 4. elamanı getirir
       liste.clear() // listeyi siler
       liste.size // listenin uzunluğunu verir
       liste.clone() // listenin kopyasını çıkarır
       liste.contains("Mur") // elemanlar içinde "Mur" değerini arar
       liste.equals("Murat") // elemanlar içinde direk "Murat" eşleşmesi arar
       liste.isEmpty().not() // liste boş ise true döndürür
       liste.isNotEmpty() // liste boş değilse true döndürür
       liste.isNullOrEmpty() // liste boş ve null değilse true döndürür*/