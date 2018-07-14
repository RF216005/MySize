package com.example.enpit_p3.mysize

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply{
            val editNeck = getString("Neck", "")
            val editSleeve = getString("Sleeve", "")
            val editWaist = getString("Waist", "")
            val editInseam = getString("Inseam", "")

            neck.setText(editNeck)
            sleeve.setText(editSleeve)
            waist.setText(editWaist)
            inseam.setText(editInseam)
        }

        save.setOnClickListener{ onSaveTapped() }

        heightButton.setOnClickListener{
            startActivity<HeightActivity>()
        }
    }


    private fun onSaveTapped() {
        val pref= PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("NECK", neck.text.toString())
                .putString("SLEEVE", sleeve.text.toString())
                .putString("WAIST", waist.text.toString())
                .putString("INSEAM", inseam.text.toString())
                .apply()
        }
}

