package br.com.pagseguro.burger.api.service

import br.com.pagseguro.burger.api.dto.BurgerDTO
import br.com.pagseguro.burger.api.entity.BurgerEntity
import br.com.pagseguro.burger.api.mapper.BurgerMapper
import br.com.pagseguro.burger.api.repository.BurgerRepository
import org.springframework.data.domain.Example.of
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BurgerService(private val mapper: BurgerMapper, private val repository: BurgerRepository) {

    fun retrieve(filter: BurgerDTO, pageable: Pageable): Page<BurgerEntity> {
        val burger = this.mapper.toEntity(filter)
        return this.repository.findAll(of(burger), pageable)
    }

    fun create(dto: BurgerDTO): BurgerDTO {
        val burger = this.mapper.toEntity(dto)
        return this.mapper.toDto(this.repository.save(burger))
    }

    fun update(id: Long, dto: BurgerDTO): BurgerEntity {
        val target = this.repository.findById(id).get()
        val source = this.mapper.toEntity(dto)
        this.mapper.merge(source, target)
        return this.repository.save(target)
    }

    fun delete(id: Long) {
        this.repository.deleteById(id)
    }
}
