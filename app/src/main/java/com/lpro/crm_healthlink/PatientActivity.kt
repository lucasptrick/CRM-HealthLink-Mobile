package com.lpro.crm_healthlink

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PatientActivity : AppCompatActivity(),
    HeaderFragment.OnMenuButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient)

        // Ao iniciar, mostrar apenas o Agendar Consulta
        showAgendarFragment()
    }

    // Quando clicar em "Agendar Consultas"
    override fun onAgendarConsultasClicked() {
        showAgendarFragment()
    }

    // Quando clicar em "Minhas Consultas"
    override fun onMinhasConsultasClicked() {
        showMinhasConsultasFragment()
    }

    private fun showAgendarFragment() {
        findViewById<View>(R.id.fragmentContainerViewAgendar).visibility = View.VISIBLE
        findViewById<View>(R.id.fragmentContainerViewMinhasConsultas).visibility = View.GONE
    }

    private fun showMinhasConsultasFragment() {
        findViewById<View>(R.id.fragmentContainerViewAgendar).visibility = View.GONE
        findViewById<View>(R.id.fragmentContainerViewMinhasConsultas).visibility = View.VISIBLE
    }
}
