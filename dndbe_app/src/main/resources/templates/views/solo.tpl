layout 'layouts/main.tpl',
pageTitle: 'RPG Tools: Solo',
mainBody: contents {
  div (class: 'container') {
    div (id: 'page-title', class: 'row text-center') {
      h1 ('Solo Roleplaying')
    }
    form (id: 'solo-form') {
      div (class: 'form-check form-check-inline') { h5 ('Chaos Level:') }
      (1..9).each { idx ->
        div (class: 'form-check form-check-inline') {
          if (idx == 5) {
            input (class: 'btn-check form-check-input', type: 'radio', id: "chaos-level-selection-${idx}",
                    name: 'chaos-level-selections', value: "${idx}", checked: 'true')
          } else {
            input (class: 'btn-check form-check-input', type: 'radio', id: "chaos-level-selection-${idx}",
                    name: 'chaos-level-selections', value: "${idx}")
          }
          label (class: 'btn btn-outline-secondary form-check-label', id: "chaos-level-selection-${idx}-label",
                   for: "chaos-level-selection-${idx}", "CL ${idx}")
        }
      }
      br{}
      div (class: 'row') {
        div (class: 'col-md-1 text-end') {
          label (id: 'odds-select-label', for: 'odds-select', 'Odds: ')
        }
        div (class: 'col-md-3') {
          select (class: 'form-select-sm', id: 'odds-select') {
            odds.each {
              if (it.name() == 'POSSIBLE') {
                option (value: it, selected: 'true', "${it.name().toLowerCase().capitalize()}")
              } else {
                option (value: it, "${it.name().toLowerCase().capitalize()}")
              }
            }
          }
        }
        div (class: 'col-md-4') {
          button (class: 'btn btn-primary', type: "submit", 'Ask the Oracle')
        }
      }
      br{}
      def oracleRoll = '7'
      def oracleMod = '3'
      def oracleTotal = '10'
      def oracleResult = 'Yes'
      div (class: 'container') {
        div (class: 'card') {
          div (class: 'card-body') {
            div (class: 'card-title') {
              h4 {
                yield 'Oracle Results: '
              }
              span (id: 'solo-console-title'){}
            }
            div (class: 'card-text', id: 'solo-console') {}
          }
        }
      }
    }
  }
}