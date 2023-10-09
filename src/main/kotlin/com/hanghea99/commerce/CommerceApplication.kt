package com.hanghea99.commerce

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing // @CreateDate @LastModifiedDate 설정
class CommerceApplication

fun main(args: Array<String>) {
	runApplication<CommerceApplication>(*args)
}
