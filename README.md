# API CRUD pada Spring Boot dengan tema "GAME"

### Base url game 
```
  https://game-aej.herokuapp.com
```

#### Table Endpoints
|Name|Endpoint|Method|
|:-----|:-----|:-----|
|ping|/v1/game/ping_game|Get|
|getAllGame|/v1/game|Get|
|getGameByName|/v1/game/namaGame|Get|
|addGame|/v1/game|Post|
|getDeleteGameByNama|/v1/game/namaGame|Delete|
|getUpdateGameByNama|/v1/game/Update_namaGame|Post|

### Game Examples
#### Game - ping
```
  Get | https://game-aej.herokuapp.com/v1/game/ping_game
```
##### Response
```
 {
    "status": true,
    "message": "Test Ping Game Berhasil",
    "data": "Ini versi game"
}
```
#### Game - getAllGame
```
  Get | https://game-aej.herokuapp.com/v1/game
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": [
        {
            "id": "1c04955f-ce6e-45dc-a24b-3db968e0e11e",
            "namaGame": "Petak Umpet",
            "developerGame": "Kampoeng",
            "hargaGame": 0
        },
        {
            "id": "833d0ef4-da2c-453e-8ad3-83242796a95d",
            "namaGame": "Table Run",
            "developerGame": "Andi",
            "hargaGame": 1000000
        }
    ]
}
```
#### Game - getGameByName
```
  Get | https://game-aej.herokuapp.com/v1/game/namaGame
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": {
        "id": "833d0ef4-da2c-453e-8ad3-83242796a95d",
        "namaGame": "Table Run",
        "developerGame": "Andi",
        "hargaGame": 1000000
    }
}
```
#### Game - addGame
```
  Post | https://game-aej.herokuapp.com/v1/game
```
##### Body
```
{
	"namaGame" : "Petak Umpet",
    "developerGame" : "Kampoeng",
    "hargaGame" : "0"
}
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": [
        {
            "id": "1c04955f-ce6e-45dc-a24b-3db968e0e11e",
            "namaGame": "Petak Umpet",
            "developerGame": "Kampoeng",
            "hargaGame": 0
        },
        {
            "id": "833d0ef4-da2c-453e-8ad3-83242796a95d",
            "namaGame": "Table Run",
            "developerGame": "Andi",
            "hargaGame": 1000000
        },
        {
            "id": "de46e4a7-8fc6-4cd5-bcd4-3bf7fd7d47ba",
            "namaGame": "Lompat Tali",
            "developerGame": "Kampoeng",
            "hargaGame": 150000
        }
    ]
}
```
#### Game - getDeleteGameByNama
```
  Delete | https://game-aej.herokuapp.com/v1/game/namaGame
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": "Hapus game berhasil"
}
```
#### Game - getUpdateGameByNama
```
  Post | https://game-aej.herokuapp.com/v1/game/Update_namaGame
```
##### Body
```
{
	"namaGame" : "Petak Umpet",
    "developerGame" : "Kampoeng",
    "hargaGame" : 100000
}
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": "Update Game Berhasil"
}
```
