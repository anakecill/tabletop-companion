package com.tabletop.companionapp.data

data class Player(
    val name: String,
    val character: String,
    val tasks: MutableList<Task>,
    val point: Point = Point(),
    var level: Int = 1,
    var taskCompleted: Int = 0
)
