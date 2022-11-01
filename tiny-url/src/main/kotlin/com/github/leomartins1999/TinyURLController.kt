package com.github.leomartins1999

import com.github.leomartins1999.interactors.CreateTinyURLInteractor
import com.github.leomartins1999.interactors.GetTinyURLInteractor
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.tinyURLController(
    getTinyURLInteractor: GetTinyURLInteractor = GetTinyURLInteractor.singleton,
    createTinyURLInteractor: CreateTinyURLInteractor = CreateTinyURLInteractor.singleton
) {
    routing {
        get("/{id}") {
            val id = call.parameters["id"]!!

            val url = getTinyURLInteractor.call(id)

            if (url.isNullOrEmpty()) {
                return@get call.respondText(
                    text = "URL not found!",
                    status = HttpStatusCode.NotFound
                )
            }

            call.respondRedirect(url)
        }

        post("/") {
            val url = call.request.header("x-tiny-url")

            if (url.isNullOrBlank()) {
                return@post call.respondText(
                    text = "x-tiny-url request header not found!",
                    status = HttpStatusCode.BadRequest
                )
            }

            val id = createTinyURLInteractor.call(url)

            call.response.header(
                "x-tiny-url-location",
                "http://localhost:8080/$id"
            )
            call.response.status(HttpStatusCode.Created)
        }
    }
}