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
        div (class: 'form-check form-check-inline p-2 g-2') {
          if (idx == 5) {
            input (class: 'btn-check form-check-input p-2 g-2', type: 'radio', id: "chaos-level-selection-${idx}",
                    name: 'chaos-level-selections', value: "${idx}", checked: 'true')
          } else {
            input (class: 'btn-check form-check-input p-2 g-2', type: 'radio', id: "chaos-level-selection-${idx}",
                    name: 'chaos-level-selections', value: "${idx}")
          }
          label (class: 'btn btn-outline-primary form-check-label p-2 g-2', id: "chaos-level-selection-${idx}-label",
                   for: "chaos-level-selection-${idx}", "CL ${idx}")
        }
      }
      br{}
      div (class: 'row') {
        div (class: 'col-md-1 text-end') {
          label (class: 'h5', id: 'odds-select-label', for: 'odds-select', 'Odds: ')
        }
        div (class: 'col-md-2') {
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
        div (class: 'col-md-2') {
          button (class: 'btn btn-primary', type: 'button', id: 'chaos', 'Roll for Chaos')
        }
        div (class: 'col-md-2') {
          button (class: 'btn btn-primary', type: 'button', id: 'oracle', 'Ask the Oracle')
        }
        div (class: 'col-md-2') {
          button (class: 'btn btn-primary', type: 'button', id: 'negative-event', 'Negative Event')
        }
        div (class: 'col-md-3') {
          button (class: 'btn btn-primary', type: 'button', id: 'positive-event', 'Neutral/Positive Event')
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
              p {span (class: 'small', id: 'solo-console-title'){}}
            }
            div (class: 'card-text', id: 'solo-console') {}
          }
        }
      }
    }
    div (class: 'row') {
    p (class: 'g-2 h5', 'Instructions')
      span (class: 'row', 'Step 1: Choose the theme and the initial hook.')
      span (class: 'row', 'Step 2: Prepare the opening scene.')
      span (class: 'row', 'Step 3: Create the characters.')
      span (class: 'row', 'Step 4: Set or Adjust the Chaos Level.')
      span (class: 'row', 'Step 5: Make a Chaos Roll and apply it to your scene.')
      span (class: 'row', 'Step 6: Play the Scene.')
      span (class: 'row', 'Step 7: Return to Step 4 until the Adventure is Concluded.')
    }
  }
}
