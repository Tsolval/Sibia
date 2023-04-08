#!groovy

def score = args? args[0] : 'Usage: modCalc [score|all]'

def calc = { Math.floor((it as int - 10) / 2) as int }

println score.isNumber() ? "${score}: ${calc(score)}" :
  score == 'all' ? (1..20).collect{"$it: ${calc(it)}"}.join('\n') :
    score

