package br.com.pagseguro.burger.api.entity

import br.com.pagseguro.burger.api.annotation.NoArgsConstructor
import br.com.pagseguro.burger.api.enums.BreadTypeEnum
import br.com.pagseguro.burger.api.enums.CheeseTypeEnum
import br.com.pagseguro.burger.api.enums.SaladTypeEnum
import br.com.pagseguro.burger.api.enums.SauceTypeEnum
import br.com.pagseguro.burger.api.enums.SizeEnum
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@NoArgsConstructor
@Table(name = "burger")
@EntityListeners(AuditingEntityListener::class)
data class BurgerEntity(

    @Id
    @Column(name = "idt_burger")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "num_quantity")
    var quantity: Int?,

    @Enumerated(STRING)
    @Column(
        name = "des_bread",
        columnDefinition = "enum('KAISER_ROLL','ONION_ROLL','POTATO_ROLL','PRETZEL_ROLL', 'SESAME_SEED_BUN', 'SLICED_BREAD')",
        nullable = false
    )
    var bread: BreadTypeEnum?,

    @Enumerated(STRING)
    @Column(name = "des_cheese", columnDefinition = "enum('CHEDDAR','SWISS','BRIE','GOUDA')", nullable = false)
    var cheese: CheeseTypeEnum?,

    @Enumerated(STRING)
    @Column(name = "des_salad", columnDefinition = "enum('LETTUCE','ARUGULA','CHARD')", nullable = false)
    var salad: SaladTypeEnum?,

    @Enumerated(STRING)
    @Column(name = "des_sauce", columnDefinition = "enum('ITALIAN','SPICY')", nullable = false)
    var sauce: SauceTypeEnum?,

    @Column(name = "flg_double")
    var double: Boolean?,

    @Enumerated(STRING)
    @Column(name = "des_size", columnDefinition = "enum('SMALL','MEDIUM','BIG')", nullable = false)
    var size: SizeEnum?,

    @CreatedDate
    @Column(name = "dat_created")
    var creationDate: LocalDateTime?,

    @LastModifiedDate
    @Column(name = "dat_updated")
    var updateDate: LocalDateTime?

)
