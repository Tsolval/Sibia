package net.tsolval.dndbe.controller.web

import net.tsolval.dndbe.model.Odds
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/solo')
class SoloController {

    @GetMapping
    def getSoloTools() {
        new ModelAndView('views/solo', [odds: Odds.values()])
    }
}
