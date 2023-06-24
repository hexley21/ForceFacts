package org.hxl.network.mapper

import java.net.URI

fun parseUrl(url: String): Int {
    val segments = URI(url).path.split("/")
    return segments[segments.size - 2].toInt()
}