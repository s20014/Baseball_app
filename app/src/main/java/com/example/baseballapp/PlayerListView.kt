package com.example.baseballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ListView
import com.example.baseballapp.databinding.ActivityPlayerListViewBinding
import org.jsoup.Jsoup

class PlayerListView : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPlayerListViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val word = intent.getStringExtra("WORD")
        val handler = Handler()

        Thread {
            val url = "https://npb.jp/bis/teams/rst_${word}.html"
            val data = arrayListOf<Player>()
            var name: String
            var link: String
            var no: String
            var day: String
            val document = Jsoup.connect(url).get()
            var selectData = document.select(".rosterPlayer")
            for (i in (1..selectData.size - 1)) {
                name = selectData[i].select(".rosterRegister").text()
                try {
                    link = selectData[i].select("a").attr("abs:href")
                } catch (e: Exception) {
                    link = ""
                }
                var select_td = selectData[i].select("td")
                no = select_td[0].text().toString()
                day = select_td[2].text().toString()
                data.add(Player(name, link, no, day))
            }

            handler.post {
                val listAdapter = PlayerListAdapter(applicationContext)
                listAdapter.players = data

                val listView: ListView = findViewById(R.id.listview) as ListView
                listView.adapter = listAdapter

                listView.setOnItemClickListener() { parent, view, position, id ->
                    val intent = Intent(this,States_View::class.java)
                    intent.putExtra("URL", data[position].url)
                    startActivity(intent)
                }
            }
        }.start()
    }
}