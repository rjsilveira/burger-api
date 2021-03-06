package br.com.pagseguro.burger.api.controller

import br.com.pagseguro.burger.api.dto.BurgerDTO
import br.com.pagseguro.burger.api.service.BurgerService
import io.swagger.annotations.ApiOperation
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/burgers")
class BurgerController(private val service: BurgerService) {

    @GetMapping
    @ApiOperation("Lista os burgers criados")
    fun retrieve(filter: BurgerDTO, @PageableDefault pageable: Pageable) = this.service.retrieve(filter, pageable)

    @PostMapping
    @ApiOperation(value = "Cria um novo burger")
    fun create(@RequestBody burger: BurgerDTO) = this.service.create(burger)

    @PatchMapping("/{id}")
    @ApiOperation(value = "Atualiza um burger existente")
    fun update(@PathVariable id: Long, @RequestBody burger: BurgerDTO) = this.service.update(id, burger)

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um burger")
    fun delete(@PathVariable id: Long) = this.service.delete(id)
}

