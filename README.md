<h1 align="center"> CartelerApp :film_strip: </h1>
<p align="center"> <img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-yellowgreen">  
<img src="https://img.shields.io/badge/PRUEBA-TECNICA-success">
<img src="https://img.shields.io/badge/EMPRESA-CENCOSUD-blue">
<img src="https://img.shields.io/badge/SO-ANDROID-orange"> 
<img src="https://img.shields.io/badge/APLICACION-MOBILE-blueviolet"> </p>

## Índice :paperclip:

* [Descripción del proyecto](#descripción-del-proyecto)

* [Estado del proyecto](#estado-del-proyecto)

* [Unit Tests](#unit-test)

* [Tecnologías utilizadas](#tecnologías-utilizadas)

## Descripción del proyecto :bookmark_tabs:

Bienvenido a CartelerApp, aplicación creada para dispositivos Android (min Sdk 26) donde encontrarás un listado de todas películas en cartelera, las cuales podrás ordenar según su fecha de estreno de manera ascendente o descendete. Si quieres tener mayor detalle cada una de ellas, simplemente selecciona la que te interese y podrás visualizar una pequeña reseña junto con los principales actores que participan en ella.
![Alt Text](Review_CartelerApp.gif)

Permisos de la app:
- Ubicación
- Cámara
- Almacenamiento

## Estado del proyecto :hammer_and_wrench:

:construction: Proyecto en construcción :construction:

- [x] Splash
- [x] Permiso de internet y dependencias
- [x] Creación Fragmentos y vinculación con layouts
- [x] Layout
- [x] Consumo Api
- [x] Repository
- [X] ViewModel
- [X] Adapter
- [X] Persistencia de datos ROOM
- [X] Navigation
- [x] Test

## Unit Tests :test_tube:

Se crean los siguientes test:
- Cuando no existe una pelicula en cartelera deberia retornar cantidad 0 - getItemCount()
- Cuando existe una pelicula en cartelera deberia retornar cantidad 1 - getItemCount()
- Convierte string a fecha correctamente - stringToDate()
- Prueba fallida de convertir string a fecha - stringToDate()

## Tecnologías utilizadas :woman_technologist:

:small_orange_diamond:	Kotlin
:small_orange_diamond:	Patrón de arquitectura MVVM
:small_orange_diamond:	Retrofit2
:small_orange_diamond:	Navigation Component
:small_orange_diamond:	Picasso
:small_orange_diamond:	Room
:small_orange_diamond:	ViewBinding