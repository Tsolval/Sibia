package net.tsolval.dndbe.controller

import org.springframework.boot.Banner
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SampleController {

    @GetMapping('/sample')
    def sample() {
        new ModelAndView ('views/home', [bootVersion: Banner.package.implementationVersion,
            groovyVersion: GroovySystem.version])
    }
}
