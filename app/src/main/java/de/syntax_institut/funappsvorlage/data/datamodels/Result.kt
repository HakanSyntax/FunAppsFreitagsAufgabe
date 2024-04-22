package de.syntax_institut.funappsvorlage.data.datamodels

data class Result(
    val artistName: String?,
    val trackName: String?,
    val artworkUrl100: String?,
    val trackTimeMillis: Int?,
    val primaryGenreName: String?, // Parçanın ana türü
    val releaseDate: String?,      // Parçanın yayınlanma tarihi
    val trackPrice: Double?

)
