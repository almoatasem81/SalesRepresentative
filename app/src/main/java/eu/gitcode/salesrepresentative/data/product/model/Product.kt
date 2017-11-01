package eu.gitcode.salesrepresentative.data.product.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Product(
        @Id var id: Long = 0,
        val name: String,
        val capacity: Float?,
        val cost: Float?,
        val description: String?
)