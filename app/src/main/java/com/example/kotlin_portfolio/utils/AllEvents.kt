package com.example.kotlin_portfolio.utils

import com.example.kotlin_portfolio.R
import kotlinx.serialization.Serializable

@Serializable
data class AllEventsItem(
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

val AllEvents  = listOf(
    AllEventsItem(
        R.drawable.banner1,
        "Dramaturgia: Branca de Neve",
        "Instituto Inhotim - Brumadinho, MG",
        "27JUN",
        Geolocation(-20.12387819956596, -44.21966627588282),
        ""
    ),
    AllEventsItem(
        R.drawable.banner2,
        "Palestra - Você é seu Negócio",
        "Museu do Amanhã - Rio de Janeiro",
        "12JUL",
        Geolocation(-22.894421640901058, -43.17954756087122),
        ""
    ),
    AllEventsItem(
        R.drawable.banner3,
        "StandUp Comedy",
        "R. João Bettega,829 - Portão, Curitiba - PR",
        "07JUL-08JUL",
        Geolocation(-25.474488772076818, -49.3024508260623),
        ""
    ),
    AllEventsItem(
        R.drawable.banner4,
        "BlockBusters House ",
        "XV de Novembro, 789 - Curitiba, PR",
        "14JUL-15JUL",
        Geolocation(-25.428952995632567, -49.26665778961207),
        ""
    ),
    AllEventsItem(
        R.drawable.banner5,
        "Theater Show",
        "SESI - Uberaba - Minas Gerais",
        "18JUL-19JUL",
        Geolocation(-19.749698032773143, -47.91644106333605),
        ""
    ),
    AllEventsItem(
        R.drawable.banner6,
        "Garden Expo",
        "Praça Rui Barbosa - Uberaba, MG",
        "20JUL",
        Geolocation(-19.749814849976797, -47.936781451983144),
        ""
    ),
    AllEventsItem(
        R.drawable.banner7,
        "Art Exhibition",
        "Centro de Cultura - Uberaba, MG",
        "22JUL-25JUL",
        Geolocation(-19.74976681677781, -47.9368962812451),
        ""
    ),
    AllEventsItem(
        R.drawable.banner8,
        "Food Festival",
        "Parque Fernando Costa - Uberaba, MG",
        "28JUL",
        Geolocation(-19.76946645189829, -47.94555013582894),
        ""
    ),
    AllEventsItem(
        R.drawable.banner9,
        "Book Fair",
        "Biblioteca Municipal - Uberaba, MG",
        "30JUL-31JUL",
        Geolocation(-19.74924171958483, -47.93200310699471),
        ""
    ),
    AllEventsItem(
        R.drawable.banner10,
        "Dance Show",
        "Teatro Vera Cruz - Uberaba, MG",
        "03AUG",
        Geolocation(-19.75639374613708, -47.939912233984565),
        ""
    ),
    AllEventsItem(
        R.drawable.banner11,
        "Film Festival",
        "Cine Vera Cruz - Uberaba, MG",
        "05AUG-06AUG",
        Geolocation(-19.756444232720792, -47.939955149324454),
        ""
    ),
    AllEventsItem(
        R.drawable.banner12,
        "Tech Conference",
        "UNIUBE - Uberaba, MG",
        "10AUG",
        Geolocation(-19.75469281688333, -47.964177593623276),
        ""
    ),
    AllEventsItem(
        R.drawable.banner13,
        "Science Fair",
        "Colégio José Ferreira - Uberaba, MG",
        "12AUG",
        Geolocation(-19.759911233971714, -47.932516276314516),
        ""
    ),
    AllEventsItem(
        R.drawable.banner14,
        "Historical Tour",
        "Museu de Arte Sacra - Uberaba, MG",
        "15AUG",
        Geolocation(-19.75789887984841, -47.96399650343779),
        ""
    ),
    AllEventsItem(
        R.drawable.banner15,
        "Sports Meet",
        "Estádio Uberabão - Uberaba, MG",
        "18AUG",
        Geolocation(-19.73907770227984, -47.940337970780845),
        ""
    ),
    AllEventsItem(
        R.drawable.banner16,
        "Museu do Ipiranga",
        "Museu do Ipiranga - R. dos Patriotas, 20, São Paulo - São Paulo",
        "19 de Julho a 31 de Agosto",
        Geolocation(-23.585371494311236, -46.60956098783668),
        ""
    ),
    AllEventsItem(
        R.drawable.banner17,
        "Museu da Língua Portuguesa",
        "Museu da Língua Portuguesa - Praça da Luz, s/nº - Portão 1, São Paulo - São Paulo",
        "18 de Julho a 31 de Agosto",
        Geolocation(-23.534760514795938, -46.635078274343485),
        ""
    ),
    AllEventsItem(
        R.drawable.banner18,
        "Allianz Parque Experience Tour",
        "Rua Palestra Itália, 200 - Portão A - Perdizes, São Paulo - SP",
        "18 de Julho a 28 de Agosto",
        Geolocation(-23.52821923045337, -46.67833880420087),
        ""
    ),
    AllEventsItem(
        R.drawable.banner19,
        "ILLUSION SHOW - UMA JORNADA MÁGICA COM HENRY E KLAUSS",
        "Teatro Villa Lobos - Shopping Villa lobos - Av. Dra. Ruth Cardoso ,4777 - 4º andar, São Paulo - SP",
        "19 a 27 de Julho",
        Geolocation(-23.551675376462608, -46.72183540133306),
        ""
    ),
    AllEventsItem(
        R.drawable.banner20,
        "(SHOW GRATUITO) Matinê de Humor - Comédia Stand Up",
        "Acústico Comedy, São Paulo - SP",
        "20 jul - 2024 • 18:00 > 20 jul - 2024 • 19:30",
        Geolocation(-23.555786033594433, -46.663472736941195),
        ""
    ),
    AllEventsItem(
        R.drawable.banner21,
        "Parla Piano - Uma Experiência Campari - 19.07",
        "REAG Belas Artes, São Paulo - SP",
        "19 jul - 2024 • 20:00 > 19 jul - 2024 • 21:30",
        Geolocation(-23.55558439865513, -46.6621217755816),
        ""
    ),
    AllEventsItem(
        R.drawable.banner22,
        "Secret Trance - Edição PVT (Open Air)",
        "REAG Belas Artes, São Paulo - SP",
        "31 ago - 2024 • 17:00 > 01 set - 2024 • 18:00",
        Geolocation(-23.55558439865513, -46.6621217755816),
        ""
    ),
    AllEventsItem(
        R.drawable.banner23,
        "Startup Weekend Education São Paulo 2024",
        "COGNA Educação, São Paulo - SP",
        "30 ago - 2024 • 17:00 > 01 set - 2024 • 20:30",
        Geolocation(-23.56567516116642, -46.65171943201215),
        ""
    ),
    AllEventsItem(
        R.drawable.banner24,
        "HOUSEHOLD SUMMIT 2024",
        "Hotel Laghetto Stilo São Paulo, São Paulo - SP",
        "11 set - 2024 • 08:15 > 12 set - 2024 • 17:30",
        Geolocation(-23.57638117995698, -46.64579692036166),
        ""
    ),
    AllEventsItem(
        R.drawable.banner25,
        "AI Summit Brasil 2024 | Mulheres na IA",
        "Universidade Presbiteriana Mackenzie, São Paulo - SP",
        "02 set - 2024 • 08:00 > 03 set - 2024 • 18:00",
        Geolocation(-23.547873341566117, -46.65013929948819),
        ""
    ),
    AllEventsItem(
        R.drawable.banner26,
        "Férias no Galpão dos Bonecos",
        "Galpão dos Bonecos, São Paulo - SP",
        "18 jul - 2024 • 14:00 > 25 jul - 2024 • 17:00",
        Geolocation(-23.52569559285173, -46.691504804390135),
        ""
    ),
    AllEventsItem(
        R.drawable.banner27,
        "Férias Radicais 24/07",
        "Espaço Safhari, São Paulo - SP",
        "24 jul - 2024 • 14:00 > 24 jul - 2024 • 18:00",
        Geolocation(-23.62227166293201, -46.67149398968019),
        ""
    ),
    AllEventsItem(
        R.drawable.banner28,
        "Museu da Imaginação",
        "Rua Virgilio Wey,100, São Paulo - São Paulo",
        "18 de Julho a 31 de Agosto",
        Geolocation(-23.51270016612143, -46.696632591528925),
        ""
    ),
    AllEventsItem(
        R.drawable.banner29,
        "BH STOCK FESTIVAL",
        "Mineirão, Belo Horizonte - MG",
        "15 ago - 2024 • 09:00 > 18 ago - 2024 • 23:00",
        Geolocation(-19.865814294448118, -43.97111944423232),
        ""
    ),
    AllEventsItem(
        R.drawable.banner30,
        "Observação Astronômica Noturna dos Astros",
        "Espaço do Conhecimento UFMG, Belo Horizonte - MG",
        "20 jul - 2024 • 19:00 > 20 jul - 2024 • 20:45",
        Geolocation(-19.931824361340112, -43.93887748980436),
        ""
    )
)
