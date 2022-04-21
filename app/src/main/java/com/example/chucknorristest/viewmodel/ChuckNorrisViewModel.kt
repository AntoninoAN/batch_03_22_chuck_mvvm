package com.example.chucknorristest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorristest.model.JokeResponse
import com.example.chucknorristest.model.JokeResponseList
import com.example.chucknorristest.model.remote.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChuckNorrisViewModel: ViewModel() {

    private val _singleJoke = MutableLiveData<JokeResponse>()
    val singleJoke: LiveData<JokeResponse>
    get() = _singleJoke

    private val _listJoke = MutableLiveData<JokeResponseList>()
    val listJoke: LiveData<JokeResponseList>
    get() = _listJoke

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
    get() = _error

    fun getSingleJoke(){
        Network.chuckApi.getRandomJoke()
            .enqueue(
                object: Callback<JokeResponse> {
                    override fun onResponse(
                        call: Call<JokeResponse>,
                        response: Response<JokeResponse>
                    ) {
                        if (response.isSuccessful){
                            response.body()?.let {
                                _singleJoke.value = it
                            } ?: kotlin.run {
                                _error.value = response.message()
                            }
                        }
                    }

                    override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                        _error.value = t.localizedMessage ?: "Unknown Error"
                    }
                }
            )
    }

    fun getNamedJoke(firstName: String, lastName: String){}

    fun getNextPage(){}
}