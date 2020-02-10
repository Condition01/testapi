package com.testapi.controller

import com.testapi.model.Card
import com.testapi.services.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@RequestMapping(value = ["/test"])
class CardController{

    @Autowired
    lateinit var cRepository : CardRepository

    @GetMapping(value = ["/getAll"])
    @ResponseBody
    fun getAllCards() : Collection<Card>{
        return this.cRepository.findAll()
    }

    @PostMapping(value = ["/insert"])
    @ResponseBody
    fun insertCard(@Valid @RequestBody card : Card) : Card{
        return this.cRepository.save(card)
    }

}