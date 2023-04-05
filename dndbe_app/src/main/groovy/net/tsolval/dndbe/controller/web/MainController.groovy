package net.tsolval.dndbe.controller.web

import org.springframework.boot.Banner
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/')
class MainController {

    @GetMapping
    def showDashboard() {
        new ModelAndView ('views/home', [bootVersion  : Banner.package.implementationVersion,
                                         groovyVersion: GroovySystem.version])
    }
}
