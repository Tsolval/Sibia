package net.tsolval.dndbe.service

import net.tsolval.dndbe.dice.service.DiceService
import net.tsolval.dndbe.model.view.ChaosResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChaosService {
    @Autowired
    DiceService dice

    def chaosDieTable = [
            1: '1d4',
            2: '1d4',
            3: '1d6',
            4: '1d6',
            5: '1d8',
            6: '1d8',
            7: '1d10',
            8: '1d12',
            9: '1d20'
    ]

    def chaosRollTable = [
            1 : 'Nothing',
            2 : 'Nothing',
            3 : 'Nothing',
            4 : 'Transmutation',
            5 : 'Abjuration',
            6 : 'Conjuration',
            7 : 'Necromancy',
            8 : 'Evocation',
            9 : 'Divination-',
            10: 'Divination+',
            11: 'Illusion',
            12: 'Enchantment',
            13: 'Transmutation',
            14: 'Abjuration',
            15: 'Conjuration',
            16: 'Necromancy',
            17: 'Evocation',
            18: 'Illusion',
            19: 'Divination-',
            20: 'Divination+'
    ]

    def chaosRollDescriptions = [
            'Nothing'      : 'Nothing needs to be changed in the scene.',
            'Transmutation': 'A small change, good or bad, changes the scene slightly.',
            'Abjuration'   : 'An element, previously of the scene, is no longer.',
            'Conjuration'  : 'An element, previously not of the scene, now is.',
            'Necromancy'   : 'Begin the scene with a Negative Event.',
            'Evocation'    : 'Begin the scene with a Neutral or Positive Event.',
            'Divination-'  : 'Create a new scene with a Negative Event and run it before, or after this one.',
            'Divination+'  : 'Create a new scene with a Neutral or Positive Event and run it before or after ths one.',
            'Illusion'     : 'Something hidden or unexpected is revealed in this scene.',
            'Enchantment'  : 'This scene changes an NPCs mood or behavior or presents a different feeling than planned.'
    ]

    ChaosResponse chaosRoll(int cl) {
        def dieRoll = dice.roll(chaosDieTable[cl])[0]
        def factor = chaosRollTable[dieRoll]
        def description = chaosRollDescriptions[factor]
        new ChaosResponse(chaosLevel: cl, dieResult: dieRoll, factor: factor, description: description)
    }
}
