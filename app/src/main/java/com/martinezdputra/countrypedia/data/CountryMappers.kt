package com.martinezdputra.countrypedia.data

import com.martinezdputra.CountriesQuery
import com.martinezdputra.CountryQuery
import com.martinezdputra.countrypedia.domain.DetailedCountry
import com.martinezdputra.countrypedia.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry() = DetailedCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No capital",
    currency = currency ?: "No currency",
    languages = languages.mapNotNull { it.name },
    continent = continent.name,
)

fun CountriesQuery.Country.toSimpleCountry() = SimpleCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No capital",
)
