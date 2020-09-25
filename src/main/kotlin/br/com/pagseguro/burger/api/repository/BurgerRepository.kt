package br.com.pagseguro.burger.api.repository

import br.com.pagseguro.burger.api.entity.BurgerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BurgerRepository : JpaRepository<BurgerEntity, Long>
