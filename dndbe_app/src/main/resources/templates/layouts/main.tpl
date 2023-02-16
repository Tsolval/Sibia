yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
  head {
    meta(charset: 'utf-8')
    meta(name: 'viewport', content: 'width=device-width, initial-scale=1')
    title(pageTitle)
    link (href: 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css',
           rel: 'stylesheet',
     integrity: 'sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD',
   crossorigin: 'anonymous')
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
            li(class:'nav-item mx-3') {
              a(class:'nav-link active', 'aria-current':'page', href:'/characters', 'Characters')
            }
            li(class:'nav-item mx-3') {
              a(class:'nav-link', href:'#', 'Game Masters')
            }
            li(class:'nav-item mx-3') {
              a(class:'nav-link', 'Solo')
            }
            li(class:'nav-item dropdown mx-3') {
              a(class:'nav-link dropdown-toggle', href:'#', 'data-bs-toggle':'dropdown', 'aria-expanded':'false', 'Rules')
              ul(class: 'dropdown-menu') {
                li{a(class: 'dropdown-item', href: '#', 'Action')}
                li{a(class: 'dropdown-item', href: '#', 'Another action')}
                li{a(class: 'dropdown-item', href: '#','Something else here')}
              }
            }
          }
          div(class: 'col-md-2 justify-content-md-end') {
            form(role:'search') {
              input(class:'form-control', type:'search', placeholder:'Search does not work', 'aria-label':'Search'){}
            }
          }
        }
      }
    }
    mainBody()
    script (src: 'https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js') {}
    script (src: 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js', integrity: 'sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN', crossorigin: 'anonymous') {}
  }
}