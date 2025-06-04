package com.lpro.crm_healthlink

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit


class PatientActivity : AppCompatActivity(),
    HeaderFragment.OnMenuButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient)

        // Carregar o fragmento padrão (Agendar Consulta)
        loadFragment(AgendarConsultaFragment())

        // Configurar botões inferiores
        val buttonAgendar = findViewById<Button>(R.id.buttonAgendar)
        val buttonMinhasConsultas = findViewById<Button>(R.id.buttonMinhasConsultas)

        buttonAgendar.setOnClickListener {
            loadFragment(AgendarConsultaFragment())
        }

        buttonMinhasConsultas.setOnClickListener {
            loadFragment(MinhasConsultasFragment())
        }
    }

    // Implementação dos botões do header
    override fun onAgendarConsultasClicked() {
        loadFragment(AgendarConsultaFragment())
    }

    override fun onMinhasConsultasClicked() {
        loadFragment(MinhasConsultasFragment())
    }

    // Função genérica para trocar fragments usando Fragment KTX
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerViewContent, fragment)
        }
    }
}
