package com.example

import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

fun main() {
    val client = HttpClient(Java).config {
        install(HttpTimeout) {
//            requestTimeoutMillis = 10_000 // respected only if the HttpTimeout plugin is installed before HttpRequestRetry
            connectTimeoutMillis = 2_000 // not respected
        }
        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 10)
            exponentialDelay()
        }
    }
    runBlocking {
        println("Sending a request...")
        client.get("http://10.255.255.10/") // some unresolvable address
    }
}
