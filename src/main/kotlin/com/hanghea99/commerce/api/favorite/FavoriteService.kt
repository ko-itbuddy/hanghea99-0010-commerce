package com.hanghea99.commerce.api.favorite

import com.hanghea99.commerce.api.common.comp.impl.FavoriteManager
import com.hanghea99.commerce.api.common.comp.impl.FavoriteReader
import com.hanghea99.commerce.api.common.domain.GetRequest
import com.hanghea99.commerce.api.favorite.domain.GetFavoriteRequest
import com.hanghea99.commerce.api.favorite.domain.GetFavoriteResponse
import com.hanghea99.commerce.api.favorite.domain.result.GetFavoriteResult
import com.hanghea99.commerce.logger
import com.querydsl.core.BooleanBuilder
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
    fun getFavorite(getFavoriteRequest: GetFavoriteRequest): GetFavoriteResponse {

        val booleanBuilder = BooleanBuilder()
        val typesValues = GetRequest.getTypesValues(getFavoriteRequest)

//        for ((idx, type) in typesValues.types.withIndex()){
//            when (type) {
//                "NAME" -> {
//                    booleanBuilder.and(
//
//                    )
//                }
//            }
//        }

//        val result = favoriteReader.readAll(
//            booleanBuilder,
//            offset = if(getFavoriteRequest.page > 0) getFavoriteRequest.page * getFavoriteRequest.count else 0,
//            count = getFavoriteRequest.count,
//            orders = when (getFavoriteRequest.sort) {
//                "LATEST" -> mutableListOf<>()
//            }
//        )

    }


}