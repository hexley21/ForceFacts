package org.hxl.network.api

import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip
import org.hxl.network.model.CharacterDTO
import org.hxl.network.model.FilmDTO
import org.hxl.network.model.ListResponse
import org.hxl.network.model.StarShipDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsService {
    @GET("people/")
    suspend fun getCharacters(@Query("page") page: Int): ListResponse<CharacterDTO>
    @GET("people/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterDTO
    @GET("people/")
    suspend fun searchCharacters(@Query("search") query: String, @Query("page") page: Int): ListResponse<CharacterDTO>

    @GET("starships/")
    suspend fun getStarShips(@Query("page") page: Int): ListResponse<StarShipDTO>
    @GET("starships/{id}")
    suspend fun getStarShipById(@Path("id") id: Int): StarShipDTO
    @GET("starships/")
    suspend fun searchStarShips(@Query("search") query: String, @Query("page") page: Int): ListResponse<StarShipDTO>

    @GET("films/")
    suspend fun getFilms(@Query("page") page: Int): ListResponse<FilmDTO>
    @GET("films/")
    suspend fun getFilmById(@Path("id") id: Int): FilmDTO
}