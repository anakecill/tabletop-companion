package com.tabletop.companionapp.data

data class Player(
    val name: String,
    val character: String,
    val tasks: MutableList<Task>,

)
