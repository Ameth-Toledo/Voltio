package com.ameth.voltio.features.login.data.datasource.remote.mapper

import com.ameth.voltio.features.login.data.datasource.remote.model.UserDto
import com.ameth.voltio.features.login.domain.entities.Auth

fun UserDto.toDomain(): Auth {
    return Auth(
        id = this.id,
        name = this.name,
        secondname = this.secondname,
        lastname = this.lastname,
        secondlastname = this.secondlastname,
        email = this.email,
        phone = this.phone,
        image_profile = this.image_profile,
        role = this.role,
        created_at = this.created_at
    )
}