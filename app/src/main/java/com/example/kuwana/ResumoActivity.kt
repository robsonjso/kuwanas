package com.example.kuwana

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kuwana.databinding.ActivityResumoBinding
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.text.NumberFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class ResumoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResumoBinding
    private lateinit var konfettiView: KonfettiView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable view binding
        binding = ActivityResumoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // Inicializa o KonfettiView
        konfettiView = binding.konfettiView  // Certifique-se de que o seu layout XML contém o KonfettiView

        // Retrieve data from Intent with default values
        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numPeople", 1)  // Default to 1 to avoid division by zero
        val percentage = intent.getIntExtra("percentage", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)

        // Format numbers as currency and percentage
        val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("pt", "AO"))
        val percentageFormatter = NumberFormat.getPercentInstance().apply { minimumFractionDigits = 0 }

        binding.tvTotalTable.text = currencyFormatter.format(totalTable)
        binding.tvNumPeopleTable.text = numPeople.toString()
        binding.tvPercentage.text = percentageFormatter.format(percentage / 100.0)
        binding.tvTotalAmount.text = currencyFormatter.format(totalAmount)

        // Inicia o confete
        startConfetti()

        // Refresh button to finish activity
        binding.btnRefresh.setOnClickListener {
            finish()
        }
    }

    private fun startConfetti() {
        // Configure a festa e inicie a animação do confete
        val party = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 3000,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            position = Position.Relative(0.5, 0.3),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100)
        )

        // Inicie a emissão de confete
        konfettiView.start(party)
    }
}
