package com.domain.mapper

interface BidirectionalMap<S, T> {

    fun map(data: S): T

    fun reverseMap(data: T): S

}