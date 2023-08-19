package net.tsolval.dndbe.controller.api

import net.tsolval.dndbe.model.Odds
import net.tsolval.dndbe.model.view.ChaosResponse
import net.tsolval.dndbe.model.view.EventResponse
import net.tsolval.dndbe.model.view.OracleResponse
import net.tsolval.dndbe.service.ChaosService
import net.tsolval.dndbe.service.EventService
import net.tsolval.dndbe.service.OracleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/api/solo')
class SoloRestController {

    @Autowired
    OracleService oracle
    @Autowired
    ChaosService chaos
    @Autowired
    EventService event

    @GetMapping('/oracle')
    OracleResponse consultOracle(@RequestParam(name = 'cl', defaultValue = '5') int chaosLevel,
                                 @RequestParam(name = 'odds', defaultValue = 'POSSIBLE') Odds odds) {
        return oracle.consult(chaosLevel, odds)
    }

    @GetMapping('/chaos')
    ChaosResponse adjustScene(@RequestParam(name = 'cl', defaultValue = '5') int chaosLevel) {
        return chaos.chaosRoll(chaosLevel)
    }

    @GetMapping('/event/negative')
    EventResponse determineNegativeEvent() {
        return event.rollNegativeEvent()
    }

    @GetMapping('/event/positive')
    EventResponse determineNeutralPositiveEvent() {
        return event.rollNeutralPositiveEvent()
    }

}
