package com.hanghea99.commerce.api.favorite

import com.hanghea99.commerce.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/favorite")
class FavoriteController(val favoriteService: FavoriteService) {

    private val log = logger()

    @GetMapping("")
    @Throws(Exception::class)
    fun getFavorite() {
        return favoriteService.getFavorite()
    }
}