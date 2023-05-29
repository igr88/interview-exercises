package dev.me.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Player {
    private String name;
    private Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class PlayersComparator {
    public static void main(String[] args) {
//        var players = new Player[] {
//                new Player("amy", 100),
//                new Player("david", 100),
//                new Player("heraldo", 50),
//                new Player("aakansha ", 75),
//                new Player("aleksa", 150),
//        };

        var input = List.of(
                "amy 100",
                "david 100",
                "heraldo 50",
                "aakansha 75",
                "aleksa 150"
        );

        var players = toPlayersArray(input);

        for (Player player : players) {
            System.out.println(player.getName() + " " + player.getScore());
        }
    }

    private static List<Player> toPlayersArray(List<String> input) {
        return input.stream()
                .map(PlayersComparator::toPlayer)
                .sorted(getPlayersComparator())
                .collect(Collectors.toList());

    }

    private static Player toPlayer(String s) {
        var tokens = s.split("\\s");
        return new Player(tokens[0], Integer.parseInt(tokens[1]));
    }

    private static Comparator<Player> getPlayersComparator() {
        return Comparator
                .comparing(Player::getScore).reversed()
                .thenComparing(Player::getName);
    }
}
