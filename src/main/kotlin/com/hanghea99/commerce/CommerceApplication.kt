package com.hanghea99.commerce

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

inline fun <reified T> T.logger() = LoggerFactory.getLogger(T::class.java)!!


@SpringBootApplication
@EnableJpaAuditing // @CreateDate @LastModifiedDate 설정
class CommerceApplication

fun main(args: Array<String>) {
	runApplication<CommerceApplication>(*args)
}
