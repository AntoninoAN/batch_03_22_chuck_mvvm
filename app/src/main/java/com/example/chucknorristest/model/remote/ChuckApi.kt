package com.example.chucknorristest.model.remote

import com.example.chucknorristest.model.JokeResponse
import com.example.chucknorristest.model.JokeResponseList
import com.example.chucknorristest.model.remote.Network.END_POINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckApi {
   @GET(END_POINT)
   fun getRandomJoke(): Call<JokeResponse>

   @GET(END_POINT)
   fun getNamedJoke(
       @Query("firstName")
       fName: String,
       @Query("lastName")
       lName: String
   ): Call<JokeResponse>

   @GET("$END_POINT/{size}")
   fun getNextPage(
       @Path("size")
       pageSize: Int = 20 //Default Arguments
   ): Call<JokeResponseList>
}



