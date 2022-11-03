package com.github.leomartins1999.interactors

import com.github.leomartins1999.gateways.RedisGateway

class GetTinyURLInteractor(
    private val redisGateway: RedisGateway = RedisGateway.singleton
) {
    suspend fun call(id: String) = redisGateway.retrieve(id)

    companion object {
        val singleton = GetTinyURLInteractor()
    }
}