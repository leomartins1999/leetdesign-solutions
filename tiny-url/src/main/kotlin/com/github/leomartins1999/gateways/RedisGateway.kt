package com.github.leomartins1999.gateways

import io.github.crackthecodeabhi.kreds.connection.Endpoint
import io.github.crackthecodeabhi.kreds.connection.newClient

class RedisGateway {
    private val client = buildClient()

    suspend fun retrieve(id: String) = client.get(id)

    suspend fun save(id: String, url: String) {
        client.set(id, url)
        client.expire(id, fiveYearsInSeconds)
    }

    private fun buildClient() = newClient(Endpoint.from("localhost:6379"))

    companion object {

        val singleton = RedisGateway()

        private val fiveYearsInSeconds = (60 * 60 * 24 * 365 * 5).toULong()
    }
}