package net.tsolval.dndbe.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.Banner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Configuration
class WebModelConfig {

  @Value('${spring.profiles.active:}')
  String profiles

  /* This bean provides the model for all controller objects and contains data that needs to go to all pages.*/
  def pageModel() {
    [
      profiles: profiles,
      bootVersion: Banner.package.implementationVersion,
      groovyVersion: GroovySystem.version
    ]
  }
}
