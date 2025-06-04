package com.lpro.crm_healthlink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class InfoBannerFragment : Fragment() {

    // Dicionário de títulos e textos (pode ser um List de Pair)
    private val contentList = listOf(
        Pair("Equipe Dedicada e Especializada", "Nosso time de profissionais de saúde trabalha em conjunto para proporcionar o melhor cuidado possível, sempre focando no conforto e na recuperação dos nossos pacientes."),
        Pair("Fornecendo Cuidado de Qualidade para Todos", "Estamos comprometidos em oferecer um atendimento de excelência, priorizando a saúde e o bem-estar de cada paciente."),
        Pair("Tecnologia a Serviço da Vida", "Utilizamos sistemas de gestão modernos para garantir um atendimento mais rápido, seguro e eficiente, do agendamento à alta hospitalar.")
    )

    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_banner, container, false)

        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val buttonNext = view.findViewById<Button>(R.id.buttonNext)
        val buttonPrevious = view.findViewById<Button>(R.id.buttonPrevious)

        // Função para atualizar os textos na tela
        fun updateContent() {
            val (title, description) = contentList[currentIndex]
            titleTextView.text = title
            descriptionTextView.text = description
        }

        // Inicializa o conteúdo na tela
        updateContent()

        // Botão NEXT
        buttonNext.setOnClickListener {
            if (currentIndex < contentList.size - 1) {
                currentIndex++
            } else {
                currentIndex = 0  // Volta para o início (loop)
            }
            updateContent()
        }

        // Botão PREVIOUS
        buttonPrevious.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
            } else {
                currentIndex = contentList.size - 1 // Vai para o último (loop)
            }
            updateContent()
        }

        return view
    }
}
