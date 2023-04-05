package net.tsolval.dndbe.service

import net.tsolval.dndbe.dice.service.DiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IdeaService {

    @Autowired
    DiceService dice

    def ideasTable = [1 : ['Game', 'Nature', 'External Factors', 'Writing', 'Avarice', 'Charisma', 'Innocent', 'Enemies'],
                      2 : ['Crime', 'Stars', 'Business', 'Intelligence', 'Power', 'Friendship', 'Hope', 'Danger'],
                      3 : ['Bad luck', 'World', 'Representative', 'Military', 'Greed', 'Good', 'Gratitude', 'Prison'],
                      4 : ['Illusion', 'Exterior', 'Bureaucracy', 'Reason', 'Envy', 'Cure', 'War', 'Disturbance'],
                      5 : ['Depravity', 'Freedom', 'Dexterity', 'New ideas', 'Drink', 'Self', 'Failure', 'Ambush'],
                      6 : ['Sleight of Hand', 'Physical', 'Order', 'Project', 'Investment', 'Peace', 'Darkness', 'Magic'],
                      7 : ['Lies', 'Winter', 'Advice', 'Tactics', 'Opulence', 'Light', 'Wounds', 'Mystery'],
                      8 : ['Insanity', 'Randomness', 'Justice', 'Technology', 'Wishes', 'Allies', 'Illness', 'Interior'],
                      9 : ['Loss', 'Art', 'News', 'Evidences', 'Fame', 'Attention', 'Tyranny', 'Balance'],
                      10: ['Draw', 'Agriculture', 'Weapons', 'Beauty', 'Pleasures', 'Sacrifice', 'Poison', 'Secret'],
                      11: ['Trade', 'Elements', 'Information', 'Benefits', 'Riches', 'Courage', 'Rage', 'Miracle'],
                      12: ['Intrigues', 'Climate', 'Tests', 'Competition', 'Expectations', 'Emotions', 'Suffering', 'Faith'],
                      13: ['Dispute', 'Way', 'Plans', 'Victory', 'Song', 'Rumors', 'Death', 'Temple'],
                      14: ['Deadlock', 'Hunting', 'Intellectual', 'Poetry', 'Joy', 'Home', 'Adversities', 'Religion'],
                      15: ['Deception', 'Horizon', 'Situation', 'Extravagance', 'Misfortune', 'Burden', 'Opposition', 'Portal'],
                      16: ['Guild', 'Wild', 'Reality', 'Public', 'Assets', 'Messages', 'Pain', 'Pact'],
                      17: ['Animals', 'Storm', 'Leadership', 'Luck', 'Mundane', 'Constitution', 'Fears', 'Spiritual'],
                      18: ['Vehicle', 'Sea', 'Knowledge', 'Success', 'Achievements', 'Protection', 'Tension', 'Wisdom'],
                      19: ['Food', 'Trip', 'Plot', 'Dreams', 'Jealous', 'Life', 'Evil', 'Energy'],
                      20: ['Environment', 'Legal Affairs', 'Invention', 'Pride', 'Possessions', 'Love', 'Strength', 'Sect'],]

    def getIdea() {
        def d20 = dice.roll('1d20')[0]
        def d8 = dice.roll('1d8')[0]

        consultIdeasTable(d20, d8)
    }

    def consultIdeasTable(int d20, int d8) {
        return ideasTable[d20][d8 - 1]
    }
}
