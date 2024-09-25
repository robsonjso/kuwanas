package com.example.kuwana

import android.os.Bundle
import android.view.View
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



          binding.btnClean.setOnClickListener { it: View? ->
              println("Menio1 " + binding.tieTotal.text)
                println("Menio1 " + binding.tieNumPeople.text)
          }

         binding.btnDone.setOnClickListener {
             val totalTableTemp = binding.tieTotal.text
             val nPeopleTemp = binding.tieNumPeople.text

             if (totalTableTemp?.isEmpty() == true ||
                 nPeopleTemp?.isEmpty() == true
                 )  {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
             } else {
                 val totalTable: Float = totalTableTemp.toString().toFloat()
                 val nPeople: Int = nPeopleTemp.toString().toInt()

                 val totaltemp = totalTable / nPeople
                 val tips = totaltemp * percentage / 100
                 val totalWithTips = totaltemp + tips
                 binding.tvResult.text = "Total with tips: $totalWithTips"
             }




         }

        }

        }




