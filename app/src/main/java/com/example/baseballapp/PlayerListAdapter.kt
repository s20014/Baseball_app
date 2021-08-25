package com.example.baseballapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class PlayerListAdapter(private val context: Context) : BaseAdapter() {
    var players: List<Player> = emptyList()
    override fun getCount(): Int = players.size
    override fun getItem(position: Int): Any? = players[position]
    override fun getItemId(position: Int): Long = 0
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
        ((convertView as? PlayerView) ?: PlayerView(context)).apply {
            setPlayer(players[position])
        }
}