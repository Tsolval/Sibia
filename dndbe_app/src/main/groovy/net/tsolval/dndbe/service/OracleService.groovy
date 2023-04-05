package net.tsolval.dndbe.service

import net.tsolval.dndbe.dice.service.DiceService
import net.tsolval.dndbe.model.Odds
import net.tsolval.dndbe.model.view.OracleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OracleService {

    @Autowired
    DiceService dice

    def oracleTable = [
            // Chaos Level:        1,   2,   3,   4,   5,   6,   7,   8,   9
            (Odds.IMPOSSIBLE):  [-10, -10, -10, -10, -10,  -8,  -7,  -5,   0],
            (Odds.UNEXPECTED):  [-10,  -9,  -9,  -8,  -8,  -5,  -3,   0,   5],
            (Odds.UNLIKELY)  :  [ -9,  -9,  -8,  -7,  -5,  -1,   0,   3,   7],
            (Odds.IMPROBABLE):  [ -9,  -8,  -7,  -6,  -3,   0,   1,   5,   8],
            (Odds.POSSIBLE)  :  [ -8,  -7,  -5,  -3,   0,   3,   5,   7,   9],
            (Odds.PROBABLE)  :  [ -6,  -5,  -1,   0,   3,   6,   7,   8,   9],
            (Odds.LIKELY)    :  [ -5,  -3,   0,   1,   5,   7,   8,   9,  10],
            (Odds.EXPECTED)  :  [ -1,   0,   3,   5,   8,   8,   9,   9,  10],
            (Odds.GUARANTEED):  [  0,   1,   5,   6,  10,  10,  10,  10,  10]
    ]

    def consult(int chaosLevel, Odds odds) {
        def response = new OracleResponse(chaosLevel: chaosLevel, odds: odds)

        response.dieResult = dice.roll('1d20')[0]
        response.modifier = oracleTable[odds][chaosLevel - 1]
        response.totalResult = response.dieResult + response.modifier
        response.description = buildOracleResultString(response.dieResult, response.totalResult)

        response
    }

    static String buildOracleResultString(int dieResult, int totalResult) {
        String answer
        String qualifier = ''

        if (totalResult <= 10) {
            answer = 'No'
            if (dieResult == 1) {
                qualifier = ', and...'
            } else if (dieResult == 20) {
                qualifier = ', but...'
            } else if (dieResult == 13) {
                qualifier = ', and something happens.  Roll a Negative Event.'
            } else if (dieResult == 7) {
                qualifier = ', but something happens.  Roll a Neutral/Positive Event.'
            }
        } else {
            answer = 'Yes'
            if (dieResult == 1) {
                qualifier = ', but...'
            } else if (dieResult == 20) {
                qualifier = ', and...'
            } else if (dieResult == 13) {
                qualifier = ', but something happens.  Roll a Negative Event.'
            } else if (dieResult == 7) {
                qualifier = ', and something happens.  Roll a Neutral/Positive Event.'
            }
        }

        "${answer}${qualifier}"
    }
}
