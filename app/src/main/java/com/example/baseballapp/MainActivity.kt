package com.example.baseballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.baseballapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //セリーグボタンがタップされたとき
        val CentralIntent = findViewById<Button>(R.id.Central)
        //パ・リーグボダンがタップされたとき
        val PacficIntent = findViewById<Button>(R.id.Pacfic)

        //セリーグボタンにリスナを登録
        CentralIntent.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, CentralActivity::class.java)
                startActivity(intent)
            }
        })

        //パ・リーグボダンにリスナを登録
        PacficIntent.setOnClickListener(object : View.OnClickListener {
            override fun onClick(c: View?) {
                val seni = Intent(this@MainActivity, PacficActivity::class.java)
                startActivity(seni)
            }
        })
        }
    }
