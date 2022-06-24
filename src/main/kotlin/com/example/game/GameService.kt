package com.example.game

interface GameService {
    fun getAllGame(): List<Game>
    fun getGameByName(name: String): Game?
    fun addGame(game: Game): List<Game>
    fun getDeleteGameByNama(name: String): String
    fun getUpdateGameByNama(name: String, game: Game): String
}