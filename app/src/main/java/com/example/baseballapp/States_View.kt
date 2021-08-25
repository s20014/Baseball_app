package com.example.baseballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.example.baseballapp.databinding.ActivityStatesViewBinding
import org.jsoup.Jsoup

class States_View : AppCompatActivity() {
    private lateinit var binding: ActivityStatesViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatesViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("URL")
        val handler = Handler()

        binding.baku.setOnClickListener { finish() }
        binding.homes.setOnClickListener { moveMainView() }



        Thread {
            val datap:MutableList<String> = mutableListOf()
            val document = Jsoup.connect(url).get()
            val data = document.select("#pc_v_name").text().split(" ")
            val pdata = document.select("#pc_bio").select("td")
            val url = document.select("#pc_v_photo").select("img").attr("abs:src")
            for (i in pdata) {
                datap.add(i.text().toString())
            }
            val no = data[0]
            val team = data[1]
            val name = data[2]
            val kana = data[3]
            val position = datap[0]
            val style = datap[1]
            val heiwei = datap[2]
            val day = datap[3]
            val career = datap[4]
            val draft = datap[5]

            handler.post{
                binding.no.text = no
                binding.team.text = team
                binding.playername.text = name
                binding.kana.text = kana
                binding.position.text = position
                binding.style.text = style
                binding.heiwei.text = heiwei
                binding.day.text = day
                binding.career.text = career
                binding.draft.text = draft
                Glide.with(this).load(url).into(binding.imageView)

            }
        }.start()
    }

    private fun moveMainView() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}

