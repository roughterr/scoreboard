package org.roughterr.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardTest {
    private static final int NEW_HOME_TEAM_SCORE = 6;
    private static final int NEW_AWAY_TEAM_SCORE = 8;

    private Scoreboard scoreboard;

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

    private Match startMatchAndUpdateScore(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore) {
        Match match = scoreboard.startNewMatch(homeTeam, awayTeam);
        Match matchUpdate = new Match(match.getHomeTeam(), match.getAwayTeam(), match.getStartTime(), homeTeamScore, awayTeamScore);
        scoreboard.update(matchUpdate);
        return match;
    }

    @Test
    public void getMatchByScoreTest() {
        // a.
        Match mexicoMatch = startMatchAndUpdateScore("Mexico", "Canada", 0, 5);
        // b.

        Match spainMatch = startMatchAndUpdateScore("Spain", "Brazil", 10, 2);
        // c.
        Match germanyMatch = startMatchAndUpdateScore("Germany", "France", 2, 2);
        // d.
        Match uruguayMatch = startMatchAndUpdateScore("Uruguay", "Italy", 6, 6);
        // e.
        Match argentinaMatch = startMatchAndUpdateScore("Argentina", "Australia", 3, 1);
        List<Match> matchesByScore = scoreboard.getMatchesByScore();
        assertEquals(uruguayMatch, matchesByScore.get(0));
        assertEquals(spainMatch, matchesByScore.get(1));
        assertEquals(mexicoMatch, matchesByScore.get(2));
        assertEquals(argentinaMatch, matchesByScore.get(3));
        assertEquals(germanyMatch, matchesByScore.get(4));
    }
}