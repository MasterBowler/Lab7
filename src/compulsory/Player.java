package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Player implements Runnable {

    private String name;
    private List<Token> takenTokens;
    private Game game;
    private int score;

    public Player(String name, Game game) {
        takenTokens = new ArrayList<>();
        this.name = name;
        this.game = game;
    }

    /**
     *  takes the first token it can get and then continues
     *  if it achieves a complete progression it will stop the game
     *  and declare itself as the winner
     */
    @Override
    public void run() {
        while (game.isPlaying()) {
            synchronized (this) {
                takeToken(game.getBoard().getTokens().get(0));
            }
            updateScore();
            if (score >= game.getCompleteProgression()) {
                synchronized (this) {
                    game.setPlaying(false);
                    game.setWinner(this);
                }
            }
        }
    }

    /**
     * calculates the longest arithmetic progression achievable
     * and then updates the score
     */
    private void updateScore() {
        int currentLength = 1;
        int previousDifference = 0;
        for (int i = 1; i < takenTokens.size(); i++) {
            if (takenTokens.get(i).getNumber() - takenTokens.get(i - 1).getNumber() == previousDifference || takenTokens.get(i).isBlank() || takenTokens.get(i-1).isBlank()) {
                ++currentLength;
            } else currentLength = 1;
            previousDifference = takenTokens.get(i).getNumber() - takenTokens.get(i - 1).getNumber();
            if (currentLength > score)
                score = currentLength;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeToken(Token token) {
        this.takenTokens.add(token);
        this.game.getBoard().removeToken(token);
    }

    public List<Token> getTakenTokens() {
        return takenTokens;
    }

    public void setTakenTokens(List<Token> takenTokens) {
        this.takenTokens = takenTokens;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
