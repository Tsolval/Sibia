package net.tsolval.dndbe.service

import net.tsolval.dndbe.model.data.BaseToon
import org.springframework.stereotype.Service

@Service
class CharacterService {

    def getAllCharacters() {
        def neo = [name: 'Neo', player: 'Keanu'] as BaseToon
        def ck = [name: 'Superman', player: 'Kent'] as BaseToon
        def jk = [name: 'Joker', player: 'Heath'] as BaseToon
        def dwd = [name: 'Dark Wing Duck', player: 'Walt'] as BaseToon
        [neo, ck, jk, dwd]
    }
}
