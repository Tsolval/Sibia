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
        assert 'No, and...' == oracle.buildOracleResultString(1, -11)
        assert 'No' == oracle.buildOracleResultString(2, 5)
        assert 'No, but...' == oracle.buildOracleResultString(20, 10)
        assert 'Yes, but...' == oracle.buildOracleResultString(1, 11)
        assert 'Yes' == oracle.buildOracleResultString(12, 13)
        assert 'Yes, and...' == oracle.buildOracleResultString(20, 30)
        assert 'Yes, but something happens.  Roll a Negative Event.' == oracle.buildOracleResultString(13, 13)
        assert 'No, but something happens.  Roll a Neutral/Positive Event.' == oracle.buildOracleResultString(7, 5)
    }
}
