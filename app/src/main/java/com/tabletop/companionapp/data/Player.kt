package com.tabletop.companionapp.data

data class Player(
    val name: String,
    val character: String,
    val tasks: MutableList<Task>? = null,
    val point: Point = Point(),
    val level: Int = 1
)
