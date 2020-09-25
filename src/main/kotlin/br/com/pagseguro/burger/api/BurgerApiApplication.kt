package br.com.pagseguro.burger.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication(proxyBeanMethods = false)
class BurgerApiApplication

fun main(args: Array<String>) {
    runApplication<BurgerApiApplication>(*args)
}
