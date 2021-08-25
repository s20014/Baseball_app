package com.example.baseballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseballapp.databinding.ActivityCentralBinding
import com.example.baseballapp.databinding.ActivityPacficBinding

class PacficActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPacficBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPacficBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Back2.setOnClickListener{ finish() }

        binding.SoftBank.setOnClickListener {movePlayersListView("h")}
        binding.Lotte.setOnClickListener {movePlayersListView("m")}
        binding.Seibu.setOnClickListener {movePlayersListView("l")}
        binding.Rakten.setOnClickListener {movePlayersListView("e")}
        binding.Nipponham.setOnClickListener {movePlayersListView("f")}
        binding.Orix.setOnClickListener {movePlayersListView("b")}

    }

    fun movePlayersListView(word :String) {
        val intent = Intent(this,PlayerListView::class.java)
        intent.putExtra("WORD",word)
        startActivity(intent)
    }
}