package com.example.game

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameServiceImpl: GameService {
    @Autowired
    private lateinit var gameRepository: GameRepository

    override fun getAllGame(): List<Game> {
        return gameRepository.getAllGame()
    }

    override fun getGameByName(name: String): Game? {
        return gameRepository.getGameByName(name)
    }

    override fun addGame(game: Game): List<Game> {
        return gameRepository.addGame(game)
    }

    override fun getDeleteGameByNama(name: String): String {
        return gameRepository.getDeleteGameByNama(name)
    }

    override fun getUpdateGameByNama(name: String, game: Game): String {
        return gameRepository.getUpdateGameByNama(name, game)
    }
}