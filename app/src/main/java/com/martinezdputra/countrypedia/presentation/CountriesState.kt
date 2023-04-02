package com.martinezdputra.countrypedia.presentation

import com.martinezdputra.countrypedia.domain.DetailedCountry
import com.martinezdputra.countrypedia.domain.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null,
)
