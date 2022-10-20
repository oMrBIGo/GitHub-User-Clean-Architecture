package org.cn.github.data.model.mapper

interface Mapper<E, D> {
    fun map(input: E): D
}