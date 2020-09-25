package br.com.pagseguro.burger.api.dto

import br.com.pagseguro.burger.api.enums.BreadTypeEnum
import br.com.pagseguro.burger.api.enums.CheeseTypeEnum
import br.com.pagseguro.burger.api.enums.SaladTypeEnum
import br.com.pagseguro.burger.api.enums.SauceTypeEnum
import br.com.pagseguro.burger.api.enums.SizeEnum

data class BurgerDTO(

    var id: Long?,

    var quantity: Int?,

    var bread: BreadTypeEnum?,

    var cheese: CheeseTypeEnum?,

    var salad: SaladTypeEnum?,

    var sauce: SauceTypeEnum?,

    var double: Boolean?,

    var size: SizeEnum?
)
