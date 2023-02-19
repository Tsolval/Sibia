package net.tsolval.dndbe.model.view

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import net.tsolval.dndbe.controller.Odds

class OracleRequest {
    @Min(1)
    @Max(9)
    int chaosLevel = 5

    @NotNull
    Odds odds = Odds.POSSIBLE
}
