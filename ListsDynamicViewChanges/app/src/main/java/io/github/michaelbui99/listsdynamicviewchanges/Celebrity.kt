package io.github.michaelbui99.listsdynamicviewchanges

enum class Gender{
    M,
    F
}
data class Celebrity(val name: String, val gender: Gender, val quote: String, val imageUrl:String ) {
}