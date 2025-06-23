#  Coroutines Android JetpackCompose: Bloque 10 JM

A new Android project Jetpack Compose.

## Getting Started

This application contains the following knowledge:

- Jetpack Compose
  
- Coroutines

## Teoria

Corrutinas : Son utiles con las que tengan que ver con bases de datos y procesos pesados,podemos
elegir que proceso se va a que hilo.

Nos permiten trabajar en diferentes hilos y sus ventajas son :

- Programacion asíncrona
  
- Trabajar con diferentes hilos
  
- Hacer tareas en segundo plano
  
- Evita cuellos de botella
  
- Evitar bloquear el hilo principal

La manera comun de trabajarlo es con las corutinas ,nos permiten ejecutar ciertas
partes del codigo en diferentes hilos , tenemos 3 diferentes :

-Proceso de la interfaz -> Distpatcher.Main
Distpatcher, elegimos el hilo en el que queremos trabajar el principal es el Main
El main se encarga de la vista principal , la interfaz, botones , textos etc.

-Proceso de llamado a API -> Distpatcher.IO
IO ,se encarga a mandar llamar todo lo que tenga que ver con una base de datos o procesos
que puedan tomar tiempo, conectarnos a un servidor , a una base de datos local etc.

Proceso de consulta a base de datos local Distpatcher.IO

-Proceso de calculos matemáticos pesados -> Distpatcher.Default

Default, es un hilo muy grande donde generamos muchos procesos matemáticos.

## Los conceptos claves de las corutinas son :

- CorutineScope -> Creamos una corrutina
  
- Distpatchers -> Elegimos el hilo
  
- Launch ->  Se ejecuta la corrutina
  
- Suspend -> Va relacionado a las funciones , ya que toda funcion que queremos ejecutar.La funcion  suspend ,son aquellas que se ejeuctan dentro de una corrutina
    y otra funcion suspend ,dentro de una corrutina debe llevar la palabra corrutina Suspend fun. 

# Flow

Es una forma de declarar a nuestras variables de otra forma ,pero de forma reactiva,pero en tiempo real.
Flow es para que se este actualizando constantemente ,ejemplo la bolsa de valores y así no usamos el mutableStateOf

### The application looks like this:
![WhatsApp Image 2025-06-22 at 18 25 51 (1)](https://github.com/user-attachments/assets/2bf67b7f-b821-472a-81ce-b858d0e628cf)
![WhatsApp Image 2025-06-22 at 18 25 52](https://github.com/user-attachments/assets/cc5bd7a7-4f32-458d-a65f-20980d1d5262)
![WhatsApp Image 2025-06-22 at 18 25 51](https://github.com/user-attachments/assets/6162793a-9e88-4ea3-808f-16244ed69a8a)
![WhatsApp Image 2025-06-22 at 18 25 51 (2)](https://github.com/user-attachments/assets/efeea1c1-304e-4730-8041-35716dc23e7b)


