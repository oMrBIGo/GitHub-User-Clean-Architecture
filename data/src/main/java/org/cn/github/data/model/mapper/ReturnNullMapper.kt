package org.cn.github.data.model.mapper

import org.cn.github.data.model.ReturnNullEntity
import org.cn.github.domain.model.ReturnNull

class ReturnNullMapper : Mapper<ReturnNullEntity, ReturnNull> {

    override fun map(input: ReturnNullEntity): ReturnNull {
        return with(input) {
            ReturnNull(
                result = null
            )
        }
    }

}