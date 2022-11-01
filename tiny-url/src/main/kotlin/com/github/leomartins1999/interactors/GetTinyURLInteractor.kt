package com.github.leomartins1999.interactors

class GetTinyURLInteractor {
    fun call(id: String) = "https://www.google.pt"

    companion object {
        val singleton = GetTinyURLInteractor()
    }
}