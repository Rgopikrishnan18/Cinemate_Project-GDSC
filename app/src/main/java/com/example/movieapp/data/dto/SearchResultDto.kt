package com.example.movieapp.data.dto


import com.example.movieapp.domain.model.SearchResult
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResultDto(
    @Json(name = "Response")
    val response: String,
    @Json(name = "Search")
    val movies: List<Movie>,
    @Json(name = "totalResults")
    val totalResults: String
)

fun SearchResultDto.toSearchResult():SearchResult{
    return SearchResult(movies=movies)
}