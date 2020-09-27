package br.com.pagseguro.burger.api.dto

data class BurgerDTO(

    var id: Long?,

    var quantity: Int?,

    var bread: String?,

    var cheese: String?,

    var salad: String?,

    var sauce: String?,

    var isdouble: Boolean?,

    var size: String?
)
