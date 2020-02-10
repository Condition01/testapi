package com.testapi.services

import com.testapi.model.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : JpaRepository<Card, Int>