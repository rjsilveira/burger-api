package br.com.pagseguro.burger.api.repository

import br.com.pagseguro.burger.api.entity.BurgerEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface BurgerRepository : ReactiveCrudRepository<BurgerEntity, Long>
