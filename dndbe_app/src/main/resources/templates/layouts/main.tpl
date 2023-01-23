yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
  head {
    meta(charset: 'utf-8')
    meta(name: 'viewport', content: 'width=device-width, initial-scale=1')
    title(pageTitle)
    link(href: 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css',
          rel: 'stylesheet',
    integrity: 'sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD',
  crossorigin: 'anonymous')
  }
  body {
    script(src: 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js',
     integrity: 'sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN',
   crossorigin: 'anonymous') {}
    div(class: 'container') {
      div(class: 'navbar') {
        div(class: 'navbar-inner') {
          a(class: 'brand',
             href: 'http://beta.groovy-lang.org/docs/groovy-2.3.2/html/documentation/markup-template-engine.html',
                   'Groovy - Template Engine docs')
          a(class: 'brand',
             href: 'http://projects.spring.io/spring-boot/') {
             yield 'Spring Boot docs'
          }
        }
      }
      mainBody()
    }
  }
}