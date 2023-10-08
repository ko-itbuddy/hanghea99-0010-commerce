package com.hanghea99.commerce.api.store.domain

data class GetStoreResponse (
    val code: String,
    val msg: String,
    val result: GetStoreResult,
)