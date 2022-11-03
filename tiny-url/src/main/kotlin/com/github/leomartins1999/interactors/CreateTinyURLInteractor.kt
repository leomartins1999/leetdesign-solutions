package com.github.leomartins1999.interactors

import com.github.leomartins1999.gateways.RedisGateway
import java.util.UUID

class CreateTinyURLInteractor(
    private val redisGateway: RedisGateway = RedisGateway.singleton
) {
    suspend fun call(url: String): String {
        val id = UUID.randomUUID().toString()

        redisGateway.save(id, url)

        return id
    }

    companion object {
        val singleton = CreateTinyURLInteractor()
    }
}