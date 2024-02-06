package com.example.movieapp.Presentation.detailsscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.domain.model.MovieData
import com.example.movieapp.ui.theme.util.MySpacer

@Composable
fun MovieData(movieData: MovieData
){
    Column(modifier= Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {

        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment= Alignment.Center){
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(movieData.poster)
                .crossfade(true)
                .build(),
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(0.5f)
            )
        }
        MySpacer(size = 12.dp)

        MovieDataItem(
            title ="Title"
            , description =movieData.title
        )


        MovieDataItem(
            title ="Actors"
            , description =movieData.actors
        )

        MovieDataItem(
            title ="awards"
            , description =movieData.awards
        )


        MovieDataItem(
            title ="Box Office"
            , description =movieData.boxOffice
        )


        MovieDataItem(
            title ="Country"
            , description =movieData.country
        )


        MovieDataItem(
            title ="Director"
            , description =movieData.director
        )


        MovieDataItem(
            title ="Genre"
            , description =movieData.genre
        )


        MovieDataItem(
            title ="Language"
            , description =movieData.language
        )


        MovieDataItem(
            title ="Production"
            , description =movieData.production
        )


        MovieDataItem(
            title ="Rated"
            , description =movieData.rated
        )


        MovieDataItem(
            title ="Released"
            , description =movieData.released
        )


        MovieDataItem(
            title ="Runtime"
            , description =movieData.runtime
        )


        MovieDataItem(
            title ="Writer"
            , description =movieData.writer
        )


        MovieDataItem(
            title ="Year"
            , description =movieData.year
        )



        MovieDataItem(
            title ="IMDB Rating"
            , description =movieData.imdbRating
        )


       MovieRatings(ratings = movieData.ratings)


        MovieDataItem(
            title ="Plot"
            , description =movieData.plot
        )
    }

}