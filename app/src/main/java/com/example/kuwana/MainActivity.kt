package com.example.kuwana

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuwana.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {   

    // Valor Total da conta
    // Numero de pessoas
    // percentagem da gorjeta
    // 10% 15% e 20%
    // calcular
    // limpar


    //Recuperar as views do layout
    // ViewBinding
    // recuperar os radios buttons
    // calculo de tip
    // mostrar resultados


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0


          binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
              if(isChecked){
                  percentage = 10
              }
          }

          binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
              if(isChecked){
                  percentage = 15
              }
          }

          binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
              if(isChecked){
                  percentage = 20
              }
          }

         val adapter = ArrayAdapter.createFromResource(
             this,
             R.array.num_people,
             android.R.layout.simple_spinner_item
         )
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

         binding.spinnerNumberOfPeople.adapter = adapter

         binding.btnDone.setOnClickListener {
             val totalTableTemp = binding.tieTotal.text

             if (totalTableTemp?.isEmpty() == true
                 )  {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
             } else {
                 val totalTable: Float = totalTableTemp.toString().toFloat()
                 val nPeople: Int = 5

                 val totaltemp = totalTable / nPeople
                 val tips = totaltemp * percentage / 100
                 val totalWithTips = totaltemp + tips
                 binding.tvResult.text = "Total with tips: " + totalWithTips
             }

           binding.btnClean.setOnClickListener {
               binding.tvResult.setText("")
               binding.tieTotal.setText("")
               binding.rbOptionOne.isChecked = false
               binding.rbOptionTwo.isChecked = false
               binding.rbOptionThree.isChecked = false
           }


         }

        }

        }




