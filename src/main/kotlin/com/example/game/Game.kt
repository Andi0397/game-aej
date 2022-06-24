package com.example.game

import java.util.*

data class Game (
    var id: String = UUID.randomUUID().toString(),
    var namaGame: String = "",
    var developerGame: String = "",
    var hargaGame: Int = 0
)