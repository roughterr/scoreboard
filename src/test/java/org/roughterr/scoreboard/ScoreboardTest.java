package org.roughterr.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardTest {
    private static final  int NEW_HOME_TEAM_SCORE = 6;
    private static final int NEW_AWAY_TEAM_SCORE = 8;

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
        Match newChelseaMatchObject = new Match(chelseaMatch.getHomeTeam(), chelseaMatch.getAwayTeam(), chelseaMatch.getStartTime());
        scoreboard.finishMatch(newChelseaMatchObject);
        assertEquals(1, scoreboard.getMatches().size());
    }

    @Test
    public void updateScoreTest() {
        Match chelseaMatch = scoreboard.startNewMatch("Chelsea", "Aston Villa");
        scoreboard.startNewMatch("Green Bay Packers", "Los Angeles Rams");
        assertEquals(2, scoreboard.getMatches().size());
        Match newChelseaMatchObject = new Match(chelseaMatch.getHomeTeam(), chelseaMatch.getAwayTeam(), chelseaMatch.getStartTime(), NEW_HOME_TEAM_SCORE, NEW_AWAY_TEAM_SCORE);
        scoreboard.update(newChelseaMatchObject);
        Match matchInScoreBoard = scoreboard.findMatch(chelseaMatch.getHomeTeam(), chelseaMatch.getAwayTeam(), chelseaMatch.getStartTime()).orElseThrow(RuntimeException::new);
        assertEquals(NEW_HOME_TEAM_SCORE, matchInScoreBoard.getHomeTeamScore());
        assertEquals(NEW_AWAY_TEAM_SCORE, matchInScoreBoard.getAwayTeamScore());
    }
}