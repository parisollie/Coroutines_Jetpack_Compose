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
    //V-86,Paso 1.5
    var resultState by mutableStateOf("")
        private set

    //Paso 2.2
    var isLoading by mutableStateOf(false)
        private set

    //Función para llamar nuestra api
    fun fetchData(){
        //launch de corrutina
        viewModelScope.launch {
            //Try-catch , para manejar errores.
            try{
                isLoading = true
                //Paso 2.1, ejecutamos la función suspendida.
                llamarApi()
            }catch (e:Exception){
                println("Error ${e.message}")
            } finally {
                /*Paso 2.3,Cuando se inicie la corrutina y termino todo
                 entonces se elimina el cargador*/
                isLoading = false
            }
        }
    }

    /*V-87,Paso 2.0 suspend para función suspendida
     La funcion suspend ,son aquellas que se ejeuctan dentro de una corrutina
    y otra funcion suspend*/
    private suspend fun llamarApi(){
        //Paso 1.11,
        val result = withContext(Dispatchers.IO){
            delay(5000)
            "Respuesta de la API"
        }
        resultState = result
    }

    //Paso 1.6, simular que andamos llamando a una APP
    fun bloqueoApp(){
        Thread.sleep(5000)
        resultState = "Respuesta de la API"
    }
}