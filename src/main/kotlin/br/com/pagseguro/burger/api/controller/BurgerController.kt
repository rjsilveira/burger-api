package br.com.pagseguro.burger.api.controller

import br.com.pagseguro.burger.api.dto.BurgerDTO
import br.com.pagseguro.burger.api.service.BurgerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/burgers")
class BurgerController(private val service: BurgerService) {

    @GetMapping
    fun retrieve() = this.service.retrieve()

    @GetMapping("/{id}")
    fun retrieveOne(@PathVariable id: Long) = this.service.retrieveOne(id)

    @PostMapping
    fun create(@RequestBody burger: BurgerDTO) = this.service.create(burger)

    @PatchMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody burger: BurgerDTO) = this.service.update(id, burger)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.service.delete(id)
}

