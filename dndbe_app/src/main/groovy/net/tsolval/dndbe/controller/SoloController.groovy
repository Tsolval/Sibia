package net.tsolval.dndbe.controller

import net.tsolval.dndbe.model.Odds
import net.tsolval.dndbe.model.view.OracleResponse
import net.tsolval.dndbe.service.OracleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/solo')
class SoloController {

    @Autowired
    OracleService oracle

    @GetMapping
    def getSoloTools() {
        new ModelAndView('views/solo', [odds: Odds.values()])
    }

    @GetMapping('/oracle')
    @ResponseBody
    OracleResponse consultOracle(@RequestParam(name = 'cl', defaultValue = '5') int chaosLevel,
                                 @RequestParam(name = 'odds', defaultValue = 'POSSIBLE') Odds odds) {
        return oracle.consult(chaosLevel, odds)
    }
}
