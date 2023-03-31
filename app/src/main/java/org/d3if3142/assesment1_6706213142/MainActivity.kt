package org.d3if3142.assesment1_6706213142

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import org.d3if3142.assesment1_6706213142.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumbitButton.setOnClickListener {hitung()}
    }
    fun hitung(){
        val harga = 100000
        val harga1 = 50000

        val selectId = binding.radioGroup1.checkedRadioButtonId
        val selectId2 = binding.radioGroup2.checkedRadioButtonId

        val cekBlnTiga = selectId == R.id.tigaBlnButton
        val cekBlnEnam = selectId == R.id.enamBlnButton
        val cekBlnSetahun = selectId == R.id.satuThnButton

        val cekWcLuar = selectId2 == R.id.wcLuarRB
        val cekWcDlm = selectId2 == R.id.wcDalamRB

        val hargaBln = if (cekBlnTiga){
            // operasinya
            val hasil = harga * 3
        }else if (cekBlnEnam){
            val hasilEnam = harga * 6
        }else {
            val hasilSetahun = harga * 12
        }

        val hargaKmrMndi = if (cekWcDlm){
            val hasilDlm = harga1 * 2
        }else {
            val hasilLuar = harga1
        }



    }
}


