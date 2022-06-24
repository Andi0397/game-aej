package com.example.game

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/game")
class GameController {
    @Autowired
    private lateinit var gameService: GameService

    @GetMapping("/ping_game")
    fun ping(): BaseResponse<String>{
        return BaseResponse(
            status = true,
            message = "Test Ping Game Berhasil",
            data = "Ini versi game"
        )
    }

    @GetMapping
    fun getAllGame(): BaseResponse<List<Game>> {
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = gameService.getAllGame()
        )
    }

    @GetMapping("/{namaGame}")
    fun getGameByName(
        @PathVariable(value = "namaGame") namagame: String
    ): BaseResponse<Game>{
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = gameService.getGameByName(namagame)
        )
    }

    @PostMapping()
    fun addGame(
        @RequestBody dataGame: Game
    ): BaseResponse<List<Game>>{
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = gameService.addGame(dataGame)
        )
    }

    @DeleteMapping("/{namaGame}")
    fun getDeleteGameByNama(
        @PathVariable(value = "namaGame") namagame: String
    ): BaseResponse<String> {
        gameService.getDeleteGameByNama(namagame)
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = "Hapus game berhasil"
        )
    }

    @PostMapping("/Update_{namaGame}")
    fun getUpdateGameByNama(
        @PathVariable(value = "namaGame") namagame: String,
        @RequestBody dataGame: Game
    ): BaseResponse<String> {
//        val cariGame = gameList.find {
//            it.namaGame == namagame
//        }.run {
//            val index = gameList.indexOf(this)
//            gameList[index] = dataGame
//            Result.success(gameList)
//        }
//        gameService.getUpdateGameByNama(namagame, dataGame)

        gameService.getUpdateGameByNama(namagame, dataGame)
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = "Update Game Berhasil"
        )
    }
}