package net.tsolval.dndbe.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/characters")
class CharacterController {

    @GetMapping
    def listCharacters() {
        def neo = new Expando(name: 'Neo', player: 'Keanu')
        def characters = [neo]
        new ModelAndView ('views/characters', [toons: characters] )
    }
}
