package com.example.kotlin_portfolio.utils

import com.example.kotlin_portfolio.R
import kotlinx.serialization.Serializable

// Types ===================================
@Serializable
data class EventsNearMeItem(
    val imageRes: Int,
    val title: String,
    val local: String,
    val eventDate: String,
    val geolocation: Geolocation,
    val distance: String?
)

@Serializable
data class Geolocation(
    val latitude: Double,
    val longitude: Double
)
// ==========================================

val EventsNearMeItems = listOf(
    EventsNearMeItem(
        R.drawable.banner1,
        "Teatro - Dramaturgia: Branca de Neve",
        "Instituto Inhotim - Brumadinho, MG",
        "27JUN",
        Geolocation(-19.934251, -44.198421),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner2,
        "Theater",
        "Museu do Amanhã - Rio de Janeiro",
        "12JUL",
        Geolocation(-22.894597, -43.181252),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner3,
        "StandUp Comedy",
        "XV de Novembro, 789 - Curitiba, PR",
        "07JUL-08JUL",
        Geolocation(-25.428954, -49.267137),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner4,
        "BlockBusters House ",
        "Instituto Inhotim - Brumadinho, MG",
        "14JUL-15JUL",
        Geolocation(-19.74833, -47.931941),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner5,
        "Theater Show",
        "SESI - Uberaba - Minas Gerais",
        "14JUL-15JUL",
        Geolocation(-19.738988, -47.931486),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner6,
        "Music Concert",
        "Praça Rui Barbosa - Uberaba, MG",
        "20JUL",
        Geolocation(-19.741074, -47.930611),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner7,
        "Art Exhibition",
        "Centro de Cultura - Uberaba, MG",
        "22JUL-25JUL",
        Geolocation(-19.747875, -47.933277),
        ' '.toString()
    ),
    EventsNearMeItem(
        R.drawable.banner8,
        "Food Festival",
        "Parque Fernando Costa - Uberaba, MG",
        "28JUL",
        Geolocation(-19.736630, -47.940590),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner9,
        "Book Fair",
        "Biblioteca Municipal - Uberaba, MG",
        "30JUL-31JUL",
        Geolocation(-19.748429, -47.930241),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner10,
        "Dance Show",
        "Teatro Vera Cruz - Uberaba, MG",
        "03AUG",
        Geolocation(-19.746536, -47.933634),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner11,
        "Film Festival",
        "Cine Vera - Uberaba, MG",
        "05AUG-06AUG",
        Geolocation(-19.750563, -47.934072),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner12,
        "Tech Conference",
        "UNIUBE - Uberaba, MG",
        "10AUG",
        Geolocation(-19.749644, -47.930612),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner13,
        "Science Fair",
        "Colégio José Ferreira - Uberaba, MG",
        "12AUG",
        Geolocation(-19.751224, -47.929217),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner14,
        "Historical Tour",
        "Museu de Arte Sacra - Uberaba, MG",
        "15AUG",
        Geolocation(-19.747773, -47.932498),
        ' '.toString()

    ),
    EventsNearMeItem(
        R.drawable.banner15,
        "Sports Meet",
        "Estádio Uberabão - Uberaba, MG",
        "18AUG",
        Geolocation(-19.735736, -47.943343),
        ' '.toString()
    )
)