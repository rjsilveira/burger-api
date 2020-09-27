package br.com.pagseguro.burger.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(proxyBeanMethods = false, exclude = [SpringDataWebAutoConfiguration::class])
class BurgerApiApplication

fun main(args: Array<String>) {
    runApplication<BurgerApiApplication>(*args)
}
