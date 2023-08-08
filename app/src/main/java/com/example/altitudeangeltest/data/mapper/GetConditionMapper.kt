package com.example.altitudeangeltest.data.mapper

import com.example.altitudeangeltest.data.models.Condition
import com.example.altitudeangeltest.data.models.dto.ConditionDTO
import javax.inject.Inject

class GetConditionMapper @Inject constructor(){

    fun fromDTO(conditions: ConditionDTO?): Condition {
        return Condition(
            text = conditions?.text,
            icon = conditions?.icon,
            code = conditions?.code
        )
    }
}
