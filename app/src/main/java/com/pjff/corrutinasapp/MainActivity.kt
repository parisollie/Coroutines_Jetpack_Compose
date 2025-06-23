package com.pjff.corrutinasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pjff.corrutinasapp.ui.theme.CorutinasAppTheme
import com.pjff.corutinasapp.ItemsViewModel
import com.pjff.corutinasapp.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Paso 1.7
          val viewModel :  MainViewModel by viewModels()
          Paso 3.7*/
        val viewModel :  ItemsViewModel by viewModels()
        setContent {
            CorutinasAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Paso 1.8, es para el botón.
                    //Content(viewModel)
                    //Paso 3.8
                    ItemsView(viewModel)
                }
            }
        }
    }
}

@Composable
/*V-85, Paso 1.0
Paso 1.9, agregamos el viewModel*/
fun Content(viewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonColor()
        if(viewModel.isLoading){
            CircularProgressIndicator()
        }else{
            /*Paso 1.2
            Paso 1.10, agregamos el viewModel.resultState*/
            Text(text = viewModel.resultState)
        }
        /*Paso 1.3
        Paso 1.12, ejecutamos el viewModel.fetchData*/
        Button(onClick = { viewModel.fetchData()}) {
            Text("Llamar API")
        }
    }
}

//Paso 1.4
@Composable
fun BotonColor(){
    var color by remember { mutableStateOf(false) }
    //Cada vez que quedemos en el boton cambia el color
    Button(onClick = { color = !color } , colors = ButtonDefaults.buttonColors(
        containerColor = if(color) Color.Blue else Color.Red
    )) {
        Text("Cambiar color")
    }
}

//Paso 3.4
@Composable
fun ItemsView(viewModel: ItemsViewModel){
    val itemsList = viewModel.itemList
    //Paso 4.2
    val lista by viewModel.lista.collectAsState()
    //Paso 3.9,llamamos a la corrutina
    LaunchedEffect(Unit){
        viewModel.fetchData()
    }

    Column {
        //Paso 2.4, si esta cargando se muestra el circular
        if(viewModel.isLoading){
            CircularProgressIndicator()
        }else{
            //Paso 3.5
            LazyColumn{
                //Paso 4.3, llamamos a lista.
                items(lista) {item ->
                    Text(text = item.name)
                }
            }
        }
    }
}