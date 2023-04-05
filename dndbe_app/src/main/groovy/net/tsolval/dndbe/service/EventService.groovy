package net.tsolval.dndbe.service

import net.tsolval.dndbe.dice.service.DiceService
import net.tsolval.dndbe.model.view.EventResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventService {

    @Autowired
    DiceService dice

    def eventDefinitions = ['Combat'             : 'A hostile party enters the scene; prepare for combat!',
                            'Objective Negative' : 'An event takes a PC or your party away from their personal or collective objective.',
                            'Objective Positive' : 'An event takes a PC or your party closer to their personal or collective objective.',
                            'NPC Negative'       : 'Something bad happens to an NPC in this scene.',
                            'NPC Positive'       : 'Something good happens to an NPC in this scene.',
                            'PC Negative'        : 'Something bad happens to a PC in this scene.',
                            'PC Positive'        : 'Something good happens to a PC in this scene.',
                            'Instigate'          : 'A PC faces a Hard (DC 20) temptation.',
                            'Background Negative': 'Choose a PC.  Their past comes back to haunt them.',
                            'Background Positive': 'Choose a PC.  They encounter something good from their past.',
                            'Magic Item Negative': 'Something bad happens involving a Magic Item.',
                            'Magic Item Positive': 'Something good happens involving a Magic Item.',
                            'Remote Event'       : 'Something important happened when the PCs were not around.',
                            'Ambiguous Event'    : 'Something happens that may or may not be good.',
                            'New NPC'            : 'Introduce a new NPC in some way.',
                            'NPC Action'         : 'An NPC takes an action that affects the PCs.']

    def eventFocusNegative(int key) {
        switch (key) {
            case (1..7): 'Combat'; break
            case (8..10): 'Objective Negative'; break
            case (11..14): 'NPC Negative'; break
            case (15..17): 'PC Negative'; break
            case 18: 'Instigate'; break
            case 19: 'Background Negative'; break
            case 20: 'Magic Item Negative'; break
        }
    }

    def eventFocusPositive(int key) {
        switch (key) {
            case (1..2): 'Remote Event'; break
            case (3..4): 'Ambiguous Event'; break
            case (5..6): 'New NPC'; break
            case (7..14): 'NPC Action'; break
            case 15: 'NPC Positive'; break
            case 16: 'PC Positive'; break
            case 17: 'Magic Item Positive'; break
            case 18: 'Background Positive'; break
            case (19..20): 'Objective Positive'; break

        }
    }

    def rollNegativeEvent() {
        rollEvent(true)
    }

    def rollNeutralPositiveEvent() {
        rollEvent(false)
    }

    def rollEvent(boolean isNegativeEvent) {
        int dieResult = dice.roll('1d20')[0]
        String type = isNegativeEvent? eventFocusNegative(dieResult) : eventFocusPositive(dieResult)
        String description = eventDefinitions[type]
        new EventResponse(dieResult: dieResult, type: type, description: description)
    }
}
