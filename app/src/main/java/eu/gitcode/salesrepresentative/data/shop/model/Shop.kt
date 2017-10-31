package eu.gitcode.salesrepresentative.data.shop.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Shop(
        @Id var id: Long = 0,
        val name: String,
        val location: String?,
        val openingHours: String?
)