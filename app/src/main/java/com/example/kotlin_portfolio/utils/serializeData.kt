package com.example.kotlin_portfolio.utils

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val json = Json { encodeDefaults = true }

//Serialize EventsNearMeItem
fun serializeEvent(event: EventsNearMeItem): String {
    return json.encodeToString(event)
}

//Deserialize EventsNearMeItem
fun deserializeEvent(jsonString: String): EventsNearMeItem {
    return json.decodeFromString(jsonString)
}

