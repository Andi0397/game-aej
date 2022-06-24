package com.example.game

import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.updateOne
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.lang.IllegalStateException

@Repository
class GameRepositoryImpl: GameRepository {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

//    private val gameList: MutableList<Game> = mutableListOf()

//    init {
//        gameList.addAll(
//            listOf(
//                Game(
//                    namaGame = "SepakBola 2k22",
//                    developerGame = "FA Sport",
//                    hargaGame = 750000
//                ),
//                Game(
//                    namaGame = "Berkebun di rumah",
//                    developerGame = "Nasi",
//                    hargaGame = 500000
//                )
//            )
//        )
//    }

    private fun gameCollection() : MongoCollection<Game> =
        databaseComponent.database.getDatabase("game").getCollection()

    override fun getAllGame(): List<Game> {
        return gameCollection().find().toList()
    }

    override fun getGameByName(name: String): Game? {
//        return gameList.find { it.namaGame == name }
        return gameCollection().findOne{ Game::namaGame eq name }
    }

    override fun addGame(game: Game): List<Game> {
//        gameList.add(
//            Game(
//                namaGame = game.namaGame,
//                developerGame = game.developerGame,
//                hargaGame = game.hargaGame
//            )
//        )
//        return gameList

        val newGame = Game(
            namaGame = game.namaGame,
            developerGame = game.developerGame,
            hargaGame = game.hargaGame
        )
        val insertGame = gameCollection().insertOne(newGame)
        return if (insertGame.wasAcknowledged()) {
            getAllGame()
        } else {
            throw IllegalStateException("Insert game gagal")
        }
    }

    override fun getDeleteGameByNama(name: String): String {
        val hapusGame = gameCollection().deleteOne(Game::namaGame eq name)
//        val cariGame = gameList.removeAll { it.namaGame == name }
        return "Hapus Game Berhasil"
    }

    override fun getUpdateGameByNama(name: String, game: Game): String {
        val gameBaru = gameCollection().updateOne(Game::namaGame eq name, game)
//        val cariGame = gameList.find {
//            it.namaGame == name
//        }.run {
//            val index = gameList.indexOf(this)
//            gameList[index] = game
//            Result.success(gameList)
//        }

//        var dataLama = gameList.find {
//            it.namaGame == name
//        }
//        dataLama?.namaGame = game.namaGame
//        dataLama?.developerGame = game.developerGame
//        dataLama?.hargaGame = game.hargaGame
        return "Update Game Berhasil"
    }
}