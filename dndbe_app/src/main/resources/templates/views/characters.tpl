layout 'layouts/main.tpl',
pageTitle: 'RPG Tools: Characters',
mainBody: contents {
  div (class: 'container') {
    div (class: 'row') {
      div (class: 'col text-center') { h1 'Characters' }
    }
    div (class: 'row') {
      table (class: 'table table-hover table-light') {
        thead (class: 'table-dark') {
          tr {
            th (scope: 'col', 'Name')
            th (scope: 'col', 'Player')
          }
        }
        tbody {
          toons.each { toon ->
            tr {
              td "$toon.name"
              td "$toon.player"
            }
          }
        }
      }
      div (class: 'col-md-12 text-end') {
        button (type: 'button', class: 'btn') {
          a (class: 'btn btn-primary', href: '/', 'Add Character')
        }
      }
    }
  }
}