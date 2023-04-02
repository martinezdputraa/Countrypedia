package com.martinezdputra.countrypedia.data

import com.apollographql.apollo3.ApolloClient
import com.martinezdputra.CountriesQuery
import com.martinezdputra.CountryQuery
import com.martinezdputra.countrypedia.domain.CountryClient
import com.martinezdputra.countrypedia.domain.DetailedCountry
import com.martinezdputra.countrypedia.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}
