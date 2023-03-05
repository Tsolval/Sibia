package net.tsolval.dndbe.service

import net.tsolval.dndbe.model.Odds
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OracleServiceTest {

    @Autowired
    OracleService oracle

    @Test
    void testConsult() {
        def table = oracle.oracleTable
        assert 0 == table[Odds.POSSIBLE][4]
    }

    @Test
    void testGetDescription() {
        assert 'No, and...' == oracle.getDescription(1, -11)
        assert 'No' == oracle.getDescription(2, 5)
        assert 'No, but...' == oracle.getDescription(20, 10)
        assert 'Yes, but...' == oracle.getDescription(1, 11)
        assert 'Yes' == oracle.getDescription(12, 13)
        assert 'Yes, and...' == oracle.getDescription(20, 30)
    }
}
