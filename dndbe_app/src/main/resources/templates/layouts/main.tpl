yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
  head {
    meta(charset: 'utf-8')
    meta(name: 'viewport', content: 'width=device-width, initial-scale=1')
    title(pageTitle)
    link (href: '/webjars/bootstrap/css/bootstrap.min.css', rel: 'stylesheet')
  }
  body {
    nav(class:'navbar navbar-expand-md navbar-dark bg-dark', 'aria-label':'RPG Tools navbar') {
      div(class:'container-fluid') {
        a(class:'navbar-brand col-md-2', href:'#', 'RPG Tools')
        button(class:'navbar-toggler', type:'button', 'data-bs-toggle':'collapse', 'data-bs-target':'#navbarsExample04', 'aria-controls':'navbarsExample04', 'aria-expanded': 'false', 'aria-label':'Toggle navigation') {
          span(class:'navbar-toggler-icon') {}
        }
        div(class:'collapse navbar-collapse', id:'navbarsExample04') {
          ul(class:'navbar-nav col-md-8 me-auto mb-3 mb-md-0 justify-content-md-center') {
            li(class:'nav-item mx-3') {
              a(class:'nav-link active', 'aria-current':'page', href:'/', 'Home')
            }
            li(class:'nav-item mx-3') { a(class:'nav-link', 'aria-current':'page', href:'/characters', 'Characters') }
            li(class:'nav-item mx-3') { a(class:'nav-link', href:'#', 'Game Masters') }
            li(class:'nav-item mx-3') { a(class:'nav-link', 'aria-current': 'page', href: '/solo', 'Solo') }
            li(class:'nav-item dropdown mx-3') {
              a(class:'nav-link dropdown-toggle', href:'/rules', 'data-bs-toggle':'dropdown', 'aria-expanded':'false', 'Rules')
              ul(class: 'dropdown-menu') {
                li { a(class: 'dropdown-item', href: '/rules/character', 'Character Creation') }
                li { a(class: 'dropdown-item', href: '/rules/chatter',   'Roleplay')           }
                li { a(class: 'dropdown-item', href: '/rules/discover',  'Discover')           }
                li { a(class: 'dropdown-item', href: '/rules/conquer',   'Conquer')            }
                li { a(class: 'dropdown-item', href: '/rules/recover',   'Recover')            }
                li { a(class: 'dropdown-item', href: '/rules/downtime',  'Downtime')           }
              }
            }
          }
          div(class: 'col-md-2 justify-content-md-end') {
            form(role:'search') {
              input(class:'form-control', type:'search', placeholder:'Search does not work', 'aria-label':'Search') {}
            }
          }
        }
      }
    }
    mainBody()
    script (src: '/webjars/bootstrap/js/bootstrap.bundle.min.js') {}
    script (src: '/js/main.js') {}
    <!-- Add LiveReload for development only -->
    if (profiles.contains('dev')) {
      script (src: 'http://localhost:35729/livereload.js?ext=Firefox&extver=20.3.0')
    }
  }
}

