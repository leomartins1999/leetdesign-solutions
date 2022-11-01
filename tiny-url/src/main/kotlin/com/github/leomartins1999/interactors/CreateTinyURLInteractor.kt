package com.github.leomartins1999.interactors

class CreateTinyURLInteractor {
    fun call(url: String) = "some-id"

    companion object {
        val singleton = CreateTinyURLInteractor()
    }
}