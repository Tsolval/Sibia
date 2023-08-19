package net.tsolval.dndbe.controller.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.Banner
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/')
class MainController {

  @Value('${spring.profiles.active:}')
  String profiles

    @GetMapping
    def showDashboard() {
        new ModelAndView('views/home', [
          profiles: profiles,
          bootVersion: Banner.package.implementationVersion, 
          groovyVersion: GroovySystem.version
        ])
    }
}
