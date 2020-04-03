package compulsory;

import java.util.List;

/**
 * Here is the logic of the game
 */
public class Game {
    private boolean playing;
    private int maxTokenValue;
    private int initialTokens;
    private int completeProgression;
    private List<Player> players;
    private Board board;
    private Player winner;

    public Game(int maxTokenValue, int initialTokens, int completeProgression) {
        winner = null;
        this.playing = true;
        this.maxTokenValue = maxTokenValue;
        this.initialTokens = initialTokens;
        this.completeProgression = completeProgression;
    }

    /**
     * checks if the game can continue
     */
    public void play() {
        board = new Board(initialTokens,maxTokenValue);
        while (playing) {
            synchronized (this) {
                if(board.getTokens().isEmpty()) {
                    playing = false;
                }
            }
        }
        if(winner != null) {
            winner.setScore(initialTokens);
            for (Player player:players) {
                if(!player.equals(winner)) {
                    player.setScore(0);
                }
            }
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public int getMaxTokenValue() {
        return maxTokenValue;
    }

    public void setMaxTokenValue(int maxTokenValue) {
        this.maxTokenValue = maxTokenValue;
    }

    public int getInitialTokens() {
        return initialTokens;
    }

    public void setInitialTokens(int initialTokens) {
        this.initialTokens = initialTokens;
    }

    public int getCompleteProgression() {
        return completeProgression;
    }

    public void setCompleteProgression(int completeProgression) {
        this.completeProgression = completeProgression;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
