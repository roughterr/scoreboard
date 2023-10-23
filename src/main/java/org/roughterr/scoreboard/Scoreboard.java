package org.roughterr.scoreboard;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
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
        matches.add(match);
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

    /**
     * Returns matches in progress ordered by their total score. The matches with the same total score will be returned
     * ordered by the most recently started match in the scoreboard.
     */
    public void getMatchesByScore() {
        //TODO
    }

    /**
     * Finds a match in the list of ongoing matches.
     *
     * @param homeTeam  the name of the home team
     * @param awayTeam  the name of the away team
     * @param startTime match start time
     * @return
     */
    public Optional<Match> findMatch(String homeTeam, String awayTeam, ZonedDateTime startTime) {
        return matches.stream().filter(m -> m.getAwayTeam().equals(awayTeam) && m.getHomeTeam().equals(homeTeam) && m.getStartTime().equals(startTime)).findFirst();
    }
}
