package com.example.kuwana

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {   

    // Valor Total da conta
    // Numero de pessoas
    // percentagem da gorjeta
    // 10% 15% e 20%
    // calcular
    // limpar


    //Recuperar as views do layout
    // find view by id
    // ViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Camel case
        val btnClean = findViewById<Button>(R.id.btn_clean)
        val btnDone = findViewById<Button>(R.id.btn_done)
        val edtTotal: TextInputEditText = findViewById(R.id.tie_total)
        val edtNumPeople: TextInputEditText = findViewById(R.id.tie_num_people)

          /*btnClean.setOnClickListener { it: View? ->
              println("Menio1 " + edtTotal.text)
                println("Menio1 " + edtNumPeople.text)
          }*/

        }

        }




