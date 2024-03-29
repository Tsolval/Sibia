package net.tsolval.dndbe.dice.service

import net.tsolval.dndbe.dice.config.DiceConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DiceService, DiceConfig])
class DiceServiceTest {

    @Autowired
    DiceService diceService

    @Test
    void testRollBasicDie() {
        // Given a set of dice to roll...
        def dieString = "6d6"

        // when the dice are rolled...
        def results = diceService.roll(dieString)

        // then the result is logical
        assert results.size() == 6
        assert results.every { die -> die in 1..6 }
    }
}
