package br.com.pagseguro.burger.api.entity

import br.com.pagseguro.burger.api.annotation.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("burger")
@NoArgsConstructor
data class BurgerEntity(

    @Id
    @Column("")
    var id: Long?,

    var quantity: Int?,

    var bread: String?,

    var cheese: String?,

    var salad: String?,

    var sauce: String?,

    var isdouble: Boolean?,

    var size: String?,

    var creation: LocalDateTime?,

    var updated: LocalDateTime?

)
