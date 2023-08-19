package net.tsolval.dndbe.controller.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/rules')
class RuleController {

    @GetMapping
    def getRules() {
        new ModelAndView('views/rules')
    }
}

