package com.example.baseballapp

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView

class PlayerView: FrameLayout {
    constructor(context: Context): super(context)

    var p_name: TextView? = null
    var p_day: TextView? = null
    var p_no: TextView? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_player, this)
        p_name = findViewById(R.id.p_name) as TextView
        p_day = findViewById(R.id.p_day) as TextView
        p_no = findViewById(R.id.p_no) as TextView
    }

    fun setPlayer(player: Player) {
        p_name?.text = player.name
        p_day?.text = player.birthday
        p_no?.text = player.no
    }
}