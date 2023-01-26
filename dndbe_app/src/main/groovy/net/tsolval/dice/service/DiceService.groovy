package net.tsolval.dice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Simulate dice for role-playing games. Roll one D20 or roll 6d6 by providing
 * the number of dice and the number of sides to the methods here.
 *
 * @author tsolval
 */
@Service
class DiceService {
    @Autowired
    Random random

    /** Roll a die and return the result.
     * @param sides - the number of sides of the die to roll
     * @return the result of the die roll
     */
    def roll(int sides) { random.nextInt(sides) + 1 }

    /** Parse a die phrase into the number of die and the size of die to roll.
     * @param phrase - a die phrase, such as "1d4" or "4d6"
     * @return an array of Integers where the first number is count and the second number is size
     */
    def parse(String dieString) { dieString.split('d').collect {it as int} }

    /** Roll a number of die and return a collection of the results of each die.  Use sum() to get the value.
     * @param number - the number of dice to roll
     * @param sides - the number of sides of the die being rolled
     * @return a collection of the results from each individual die
     */
    def roll(int number, int sides) { (1..number).collect{ roll(sides) } }

    /** Roll a number of die signified by a die phrase and return a collection of the results of each die.
     * A die phrase indicates the number of dice to roll and the size of the dice separated by a letter d.
     * For example: "1d4" means roll 1, 4-sided die.  While "4d6" means to roll 4, 6-sided die.
     * Use sum() to get the value.
     * @param phrase - a string indicating the number and size of a die to roll
     * @return a collection of the results from each individual die
     */
    def roll(String phrase) {
        def (count, sides) = parse phrase
        roll count, sides
    }
}
