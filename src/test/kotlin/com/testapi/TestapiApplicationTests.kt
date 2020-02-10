package com.testapi

import com.testapi.services.CardRepository
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource
import com.testapi.model.Card
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.BeforeAll
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig
import java.util.*
import org.easymock.EasyMock

//import M


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//		classes = { StudentJpaConfig.class },
//		loader = AnnotationConfigContextLoader.class))
@SpringBootTest
@SpringJUnitWebConfig
@Transactional
class TestapiApplicationTests  {



	@Resource
	lateinit var cardRepository : CardRepository



	companion object{
		val id : TestIten = EasyMock.createMock<TestIten>(TestIten::class.java)

		@BeforeAll
		@JvmStatic
		fun setUp(){
			println("EU AMO MINHA VIDA")
//			val id = EasyMock.createMock<TestIten>(TestIten::class.java)
		}
	}


//	@Test
//	fun contextLoads() {
//
//	}
	@Test
	fun insertCard(){
		val card = Card(1, "Dragão branco")
		val c : Card? = cardRepository.save(card)
		assert(c != null)
	}

	@Test
	fun selectCard(){
		EasyMock.expect(id!!.getId()).andReturn(1)
		EasyMock.replay(id!!)

		val meuId = id!!.getId()

		var cardTest : Optional<Card> = cardRepository.findById(meuId)
		assert(!cardTest.isPresent)
		EasyMock.verify(id)
	}

}

interface TestIten {
	fun getId() : Int
}
