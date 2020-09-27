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

    fun retrieve(filter: BurgerDTO): String {
        val burger = this.mapper.toEntity(filter)
        // return this.repository.findAll(of(burger), pageable)
        return "this.repository.findAll(of(burger), pageable)"
    }

    fun create(dto: BurgerDTO): Mono<BurgerDTO> {
        val burger = this.mapper.toEntity(dto)
        burger.creation = now()
        burger.updated = now()
        return this.repository.save(burger).map { this.mapper.toDto(it) }
    }

    fun update(id: Long, dto: BurgerDTO): BurgerEntity {
        val target = this.repository.findById(id).block()!!
        val source = this.mapper.toEntity(dto)
        this.mapper.merge(source, target)
        return this.repository.save(target).block()!!
    }

    fun delete(id: Long) {
        this.repository.deleteById(id)
    }
}
