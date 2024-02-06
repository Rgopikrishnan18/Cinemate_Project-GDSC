package com.example.movieapp.domain.repository

import com.example.movieapp.data.dto.MovieDataDto
import com.example.movieapp.data.dto.SearchResultDto

interface RemoteDataRepository {
    suspend fun getMovieData(title:String):MovieDataDto

    suspend fun getSearchResult(search:String):SearchResultDto

}