package com.pjff.corutinasapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainViewModel: ViewModel() {
    //Vid 86
    var resultState by mutableStateOf("")
        private set

    //Vid 87
    var isLoading by mutableStateOf(false)
        private set

    //Vid 87, funcion para llamar nuestra api
    fun fetchData(){
        //lanch de ecorrutina
        viewModelScope.launch {
            try{
                isLoading = true
                llamarApi()
            }catch (e:Exception){
                println("Error ${e.message}")
            } finally {
                //cuando se iniie la ecorrutina se elimina el cargador
                isLoading = false
            }
        }
    }

    //Vid 87, suspend para suspendida
    /* La funcion suspend ,son aquellas que se ejeuctan dentro de una corrutina y otra funcion suspend*/
    private suspend fun llamarApi(){
        val result = withContext(Dispatchers.IO){
            delay(5000)
            "Respuesta de la API"
        }
        resultState = result
    }


    //Vid 85
    fun bloqueoApp(){
        Thread.sleep(5000)
        resultState = "Respuesta de la API"
    }
}