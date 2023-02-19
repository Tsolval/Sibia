package net.tsolval.dndbe.dice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DiceConfig {

    /** Get a Random generator.
     * @return a new Random generator class
     */
    @Bean
    Random getRandom() { new Random() }
}
