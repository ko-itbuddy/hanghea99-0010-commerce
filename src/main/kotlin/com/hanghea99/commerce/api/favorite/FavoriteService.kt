package com.hanghea99.commerce.api.favorite

import com.hanghea99.commerce.api.common.comp.impl.FavoriteManager
import com.hanghea99.commerce.api.common.comp.impl.FavoriteReader
import com.hanghea99.commerce.logger
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class FavoriteService (
    var favoriteManager: FavoriteManager,
    var favoriteReader: FavoriteReader,
){
    private val log = logger()

    @Throws(Exception::class)
    fun getFavorite(){

    }


}