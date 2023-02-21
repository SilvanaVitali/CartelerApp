package com.silvanav.cartelerapp.view


import com.silvanav.cartelerapp.model.Movie
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class MovieAdapterTest {
    private lateinit var adapter : MovieAdapter
    private lateinit var localDate : LocalDate

    @Before
    fun onBefore() {
        adapter= MovieAdapter()
    }

    @Test
    fun `Cuando no existe una pelicula en cartelera deberia retornar cantidad 0 - getItemCount()`() {
        assertEquals(adapter.getItemCount(),0)
    }

    @Test
    fun `Cuando existe una pelicula en cartelera deberia retornar cantidad 1 - getItemCount()`() {
        var movie = Movie("tt1649418",
            "The Gray Man",
            "https://m.media-amazon.com/images/M/MV5BOWY4MmFiY2QtMzE1YS00NTg1LWIwOTQtYTI4ZGUzNWIxNTVmXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX128_CR0,4,128,176_AL_.jpg",
            "Ryan Gosling, Chris Evans, Ana de Armas, Billy Bob Thornton",
            "When the CIA's most skilled operative-whose true identity is known to none-accidentally uncovers dark agency secrets, a psychopathic former colleague puts a bounty on his head, setting off a global manhunt by international assassins.",
            "22 Jul 2022",
            " ")
        val list = listOf(movie)
        list.plus(movie)
        adapter.update(list, "Ascendiente",true)
        assertEquals(adapter.getItemCount(),1)
    }

    @Test
    fun `Convierte string a fecha correctamente - stringToDate()`() {
        localDate = adapter.stringToDate("22 Feb 2023")
        assertEquals(localDate, LocalDate.of(2023, 2,22))
    }

    @Test
    fun `Prueba fallida de convertir string a fecha - stringToDate()`() {
        localDate = adapter.stringToDate("22 Feb 2023")
        assertNotEquals(localDate, LocalDate.of(2024, 2,22))
    }
}