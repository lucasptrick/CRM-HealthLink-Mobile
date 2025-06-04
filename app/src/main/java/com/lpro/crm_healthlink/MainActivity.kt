package com.lpro.crm_healthlink

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // inflando os Fragments
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.add(R.id.fragmentContainerView, HeaderFragment())
            transaction.add(R.id.fragmentContainerViewInfoBannerFragment, InfoBannerFragment())
            transaction.add(R.id.fragmentContainerHidden, MenuHiddenFragment())

            transaction.commit()
        }

    }


    fun openLogin(view: View) {
        val intent = Intent(this, com.lpro.crm_healthlink.ui.login.LoginActivity::class.java)
        startActivity(intent)
    }



    // Função para exibir/ocultar o menu do HeaderFragments
    fun onToggleHiddenFragment() {
        val hiddenFragmentContainer = findViewById<View>(R.id.fragmentContainerHidden)

        hiddenFragmentContainer.visibility = if (hiddenFragmentContainer.visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }
}