package br.com.pagseguro.burger.api.service

import br.com.pagseguro.burger.api.dto.BurgerDTO
import br.com.pagseguro.burger.api.entity.BurgerEntity
import br.com.pagseguro.burger.api.mapper.BurgerMapper
import br.com.pagseguro.burger.api.repository.BurgerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime.now

@Service
class BurgerService(private val mapper: BurgerMapper, private val repository: BurgerRepository) {

    fun retrieve() = this.repository.findAll()

    fun retrieveOne(id: Long) = this.repository.findById(id)

    fun create(dto: BurgerDTO): Mono<BurgerDTO> {
        val burger = this.mapper.toEntity(dto)
        burger.creation = now()
        burger.updated = now()
        return this.repository.save(burger).map { this.mapper.toDto(it) }
    }

    fun update(id: Long, dto: BurgerDTO): Mono<BurgerEntity> {
        return this.repository.findById(id)
            .doOnNext {
                val source = this.mapper.toEntity(dto)
                this.mapper.merge(source, it)
                it.updated = now()
            }
            .flatMap {
                this.repository.save(it)
            }
    }

    fun delete(id: Long) = this.repository.deleteById(id)
}
