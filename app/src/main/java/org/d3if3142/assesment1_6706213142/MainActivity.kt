package org.d3if3142.assesment1_6706213142

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.Toast
import org.d3if3142.assesment1_6706213142.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumbitButton.setOnClickListener {hitung()}
        binding.clearButton.setOnClickListener {clear()}
    }
    fun hitung(){
        val harga = 100000
        val hargaWcDalam = 50000

        val inpNama = binding.namaInp.text.toString()
        if(TextUtils.isEmpty(inpNama)){
            Toast.makeText(this, R.string.nama_invalid, Toast.LENGTH_LONG).show()
        }

        val inpNoKamar = binding.noKamarInp.text.toString()
        if(TextUtils.isEmpty(inpNoKamar)){
            Toast.makeText(this, R.string.no_invalid, Toast.LENGTH_LONG).show()
        }

        val selectId = binding.radioGroup1.checkedRadioButtonId
        if(selectId == -1){
            Toast.makeText(this, R.string.bln_invalid, Toast.LENGTH_LONG).show()
        }

        val selectId2 = binding.radioGroup2.checkedRadioButtonId
        if(selectId2 == -1){
            Toast.makeText(this, R.string.kmrmandi_invalid, Toast.LENGTH_LONG).show()
        }

        val cekBlnTiga = selectId == R.id.tigaBlnButton
        val cekBlnEnam = selectId == R.id.enamBlnButton

        val cekWcDlm = selectId2 == R.id.wcDalamRB

        val hargaBln = if (!TextUtils.isEmpty(inpNama) && !TextUtils.isEmpty(inpNoKamar) && (selectId2 == R.id.wcDalamRB || selectId2 == R.id.wcLuarRB)){
            if (cekBlnTiga){
                // operasinya
                harga.toFloat() * 3.0
            }else if (cekBlnEnam){
                harga.toFloat() * 6.0
            }else {
                harga.toFloat() * 12.0
            }
        }else{
            0.0
        }

        val hargaKmrMndi = if (!TextUtils.isEmpty(inpNama) && !TextUtils.isEmpty(inpNoKamar) && (selectId == R.id.tigaBlnButton || selectId == R.id.enamBlnButton || selectId == R.id.satuThnButton)){
            if (cekWcDlm){
                hargaWcDalam.toFloat()
            }else {
                0.0
            }
        }else{
            0.0
        }

        val total = hargaBln.toFloat() + hargaKmrMndi.toFloat()
        binding.totalHasil.text = getString(R.string.totalHasil, total)


    }

    fun clear(){
        val nama = binding.namaInp.text.toString()
        val noKamar = binding.noKamarInp.text.toString()
        val selectId01 = binding.radioGroup1.checkedRadioButtonId
        val selectId02 = binding.radioGroup2.checkedRadioButtonId

        if(TextUtils.isEmpty(nama) && TextUtils.isEmpty(noKamar) && selectId01 == -1 && selectId02 == -1){
            Toast.makeText(this, R.string.clear_invalid, Toast.LENGTH_LONG).show()
        }

        val inpNama = binding.namaInp
        val inpNoKamar = binding.noKamarInp
        val hasil = binding.totalHasil
        val selectId = binding.radioGroup1
        val selectId2 = binding.radioGroup2


        inpNama.text = null
        inpNoKamar.text = null
        hasil.text = "0"
        selectId.clearCheck()
        selectId2.clearCheck()
    }
}


