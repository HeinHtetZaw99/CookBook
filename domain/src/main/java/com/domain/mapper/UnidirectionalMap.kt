package com.domain.mapper

interface UnidirectionalMap<S, T> {

  fun map(data: S): T
}