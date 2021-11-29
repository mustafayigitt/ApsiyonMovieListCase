package com.mustafayigit.apsiyonmovielistcase.data.remote.response


/*
{
    "page": 1,
    "results": [
    {
        "adult": false,
        "backdrop_path": "/70nxSw3mFBsGmtkvcs91PbjerwD.jpg",
        "genre_ids": [
        878,
        28,
        12
        ],
        "id": 580489,
        "original_language": "en",
        "original_title": "Venom: Let There Be Carnage",
        "overview": "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
        "popularity": 24007.174,
        "poster_path": "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
        "release_date": "2021-09-30",
        "title": "Venom: Let There Be Carnage",
        "video": false,
        "vote_average": 7.2,
        "vote_count": 3451
    },
    ],
    "total_pages": 500,
    "total_results": 10000
}*/


data class ResponseMovie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
)

data class ResponseMovieList(
    val page: Int,
    val results: List<ResponseMovie>,
    val total_pages: Int,
    val total_results: Int,
)