package org.roughterr.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardTest {
    private Scoreboard scoreboard = new Scoreboard();

    @BeforeEach
    public void initEach() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void deleteSuccessfulTest() {
        Match chelseaMatch = scoreboard.startNewMatch("Chelsea", "Aston Villa");
        scoreboard.startNewMatch("Green Bay Packers", "Los Angeles Rams");
        assertEquals(2, scoreboard.getMatches().size());
        scoreboard.finishMatch(new Match(chelseaMatch.getHomeTeam(), chelseaMatch.getAwayTeam(), chelseaMatch.getStartTime()));
        assertEquals(1, scoreboard.getMatches().size());
    }
}