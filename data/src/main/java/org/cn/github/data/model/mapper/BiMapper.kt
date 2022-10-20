package org.cn.github.data.model.mapper

interface BiMapper<E, D> {
    fun mapFromEntity(input: E): D
    fun mapToEntity(input: D): E
}