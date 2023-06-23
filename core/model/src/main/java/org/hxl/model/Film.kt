package org.hxl.model

data class Film(
    val title: List<String>,
    val episodeId: List<Int>,
    val director: Set<String>,
    val producer: Set<String>,
)