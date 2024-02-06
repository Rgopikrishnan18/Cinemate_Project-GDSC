package com.example.movieapp.Presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.data.dto.toMovieData
import com.example.movieapp.data.dto.toSearchResult
import com.example.movieapp.domain.model.MovieData
import com.example.movieapp.domain.model.SearchResult
import com.example.movieapp.domain.use_case.UseCases
import com.example.movieapp.ui.theme.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel  @Inject constructor(
    private val useCases: UseCases
):ViewModel(){
    private val _movieDataResponse=MutableStateFlow<Result<MovieData>>(Result.Idle)
    val movieDataResponse=_movieDataResponse.asStateFlow()

    private val _searchResponse=MutableStateFlow<Result<SearchResult>>(Result.Idle)
    val searchResponse=_searchResponse.asStateFlow()

    fun getMovieData(
        title:String
    )=viewModelScope.launch{
        useCases.getMovieDataUseCase(title)
            .onStart {
                _movieDataResponse.value=Result.Loading
            }.catch{_movieDataResponse.value=Result.Error(it)
            }.collect{
                val result=it.toMovieData()
                _movieDataResponse.value= Result.Success(result)
            }

    }

    fun getSearchResult(
        search:String
    )=viewModelScope.launch {
        useCases.getSearchResultUseCase(search)
            .onStart {
                _searchResponse.value=Result.Loading
            }.catch {
                _searchResponse.value=Result.Error(it)
            }.collect{
                val result=it.toSearchResult()
                _searchResponse.value=Result.Success(result)
            }
    }
}