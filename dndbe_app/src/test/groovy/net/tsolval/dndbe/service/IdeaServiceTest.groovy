package net.tsolval.dndbe.service

import net.tsolval.dndbe.dice.service.DiceService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class IdeaServiceTest {

    static IdeaService service
    static def ideas

    @BeforeAll
    static void collectIdeas() {
        service = new IdeaService()
        service.dice = new DiceService()
        service.dice.random = new Random()
        ideas = service.ideasTable.collectMany {it.value}
    }

    @Test
    void testIdeasTable() {
        assert 20 * 8 == ideas.size()
        assert 'Physical' == service.ideasTable[6][1]
        assert 'Sect' == service.ideasTable[20][7]
    }

    @Test
    void testGetIdea() {
        assert service.idea in ideas
        assert 'Game' == service.consultIdeasTable(1, 1)
        assert 'Sect' == service.consultIdeasTable(20, 8)
    }
}
