package br.com.pagseguro.burger.api.mapper

import br.com.pagseguro.burger.api.dto.BurgerDTO
import br.com.pagseguro.burger.api.entity.BurgerEntity
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.NullValueCheckStrategy.ALWAYS
import org.mapstruct.NullValuePropertyMappingStrategy.IGNORE

@Mapper
interface BurgerMapper {

    fun toEntity(dto: BurgerDTO): BurgerEntity

    fun toDto(entity: BurgerEntity): BurgerDTO

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE, nullValueCheckStrategy = ALWAYS)
    fun merge(source: BurgerEntity, @MappingTarget target: BurgerEntity)
}
