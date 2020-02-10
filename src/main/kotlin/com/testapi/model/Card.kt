package com.testapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "tbl_card")
data class Card(
        @Id
        @Column(name = "card_id", nullable = false)
        @NotBlank
        val id : Int,
        @NotBlank
        @Column(name = "card_nome", nullable = false)
        val nome : String
)