package com.example.baseballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseballapp.databinding.ActivityCentralBinding


class CentralActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCentralBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCentralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Back1.setOnClickListener { finish() }

        binding.Kyozin.setOnClickListener {movePlayersListView("g")}
        binding.Hansin.setOnClickListener {movePlayersListView("t")}
        binding.Tyunichi.setOnClickListener {movePlayersListView("d")}
        binding.Yokohama.setOnClickListener {movePlayersListView("db")}
        binding.Carp.setOnClickListener {movePlayersListView("c")}
        binding.Yaklt.setOnClickListener {movePlayersListView("s")}

    }

    fun movePlayersListView(word :String) {
        val intent = Intent(this,PlayerListView::class.java)
        intent.putExtra("WORD",word)
        startActivity(intent)
    }
}