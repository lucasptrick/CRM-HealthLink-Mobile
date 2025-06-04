package com.lpro.crm_healthlink

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible

class HeaderFragment : Fragment() {

    interface OnMenuButtonClickListener {
        fun onAgendarConsultasClicked()
        fun onMinhasConsultasClicked()
    }

    private var menuListener: OnMenuButtonClickListener? = null
    private lateinit var hiddenMenuLayout: View

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnMenuButtonClickListener) {
            menuListener = context
        } else {
            throw RuntimeException("$context must implement OnMenuButtonClickListener")
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_header, container, false)

        val menuButton = view.findViewById<ImageButton>(R.id.imageButton2)

        hiddenMenuLayout = view.findViewById(R.id.hiddenMenuLayout)
        hiddenMenuLayout.visibility = View.GONE

        menuButton.setOnClickListener {
            toggleHiddenMenu()
        }

        val buttonAgendar = view.findViewById<Button>(R.id.buttonAgendarConsultas)
        val buttonMinhas = view.findViewById<Button>(R.id.buttonMinhasConsultas)

        buttonAgendar.setOnClickListener {
            menuListener?.onAgendarConsultasClicked()
            hiddenMenuLayout.visibility = View.GONE
        }

        buttonMinhas.setOnClickListener {
            menuListener?.onMinhasConsultasClicked()
            hiddenMenuLayout.visibility = View.GONE
        }

        return view
    }

    fun toggleHiddenMenu() {
        hiddenMenuLayout.visibility =
            if (hiddenMenuLayout.isVisible) View.GONE else View.VISIBLE
    }

    override fun onDetach() {
        super.onDetach()
        menuListener = null
    }
}
