package org.roughterr.scoreboard;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Immutable match object.
 */
public class Match {
    /**
     * The name of the home team.
     */
    private String homeTeam;

    /**
     * The name of the away team.
     */
    private String awayTeam;

    /**
     * Time when the match started.
     */
    private ZonedDateTime startTime;

    /**
     * Home team's score.
     */
    private int homeTeamScore = 0;

    /**
     * Away team's score.
     */
    private int awayTeamScore = 0;

    /**
     * @param homeTeam      the name of the home team
     * @param awayTeam      the name of the away team
     * @param startTime     the time when the match started
     * @param homeTeamScore the score of the home team
     * @param awayTeamScore the score of the away team
     */
    public Match(String homeTeam, String awayTeam, ZonedDateTime startTime, int homeTeamScore, int awayTeamScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = startTime;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    /**
     * @param homeTeam  the name of the home team
     * @param awayTeam  the name of the away team
     * @param startTime the time when the match started
     */
    public Match(String homeTeam, String awayTeam, ZonedDateTime startTime) {
        this(homeTeam, awayTeam, startTime, 0, 0);
    }

    /**
     * @param homeTeam the name of the home team
     * @param awayTeam the name of the away team
     */
    public Match(String homeTeam, String awayTeam) {
        this(homeTeam, awayTeam, ZonedDateTime.now(), 0, 0);
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;

        if (!Objects.equals(homeTeam, match.homeTeam)) return false;
        if (!Objects.equals(awayTeam, match.awayTeam)) return false;
        return Objects.equals(startTime, match.startTime);
    }

    @Override
    public int hashCode() {
        int result = homeTeam != null ? homeTeam.hashCode() : 0;
        result = 31 * result + (awayTeam != null ? awayTeam.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", startTime=" + startTime +
                ", homeTeamScore=" + homeTeamScore +
                ", awayTeamScore=" + awayTeamScore +
                '}';
    }
}
