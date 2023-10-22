package org.roughterr.scoreboard;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A new Live Football World Cup Scoreboard library that shows all the ongoing matches and their scores.
 */
public class Scoreboard {
    private Set<Match> matches = new HashSet<>();

    /**
     * Starts a new match.
     *
     * @param homeTeam the name of the home team
     * @param awayTeam the name of the away team
     * @return match object that also contains the creation date
     */
    public Match startNewMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(new Match(homeTeam, awayTeam));
        return match;
    }

    /**
     * Returns all matches.
     *
     * @return
     */
    public Set<Match> getMatches() {
        return Collections.unmodifiableSet(matches);
    }

    /**
     * Updates score.
     *
     * @param match
     */
    public void update(Match match) {
        matches.add(match);
    }

    /**
     * Finishes match currently in progress.
     */
    public void finishMatch(Match match) {
        matches.remove(match);
    }

    public void getMatchesByScore() {
       //TODO
    }
}
