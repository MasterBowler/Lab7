package compulsory;

import java.util.*;

public class Board {
    private List<Token> tokens;

    /**
     *  Generates a board
     * @param initialTokens how many tokens should the board be initialized with
     * @param maxTokenValue the maximum value of a token (1..maxTokenValue)
     */
    public Board(int initialTokens,int maxTokenValue) {
        tokens = new LinkedList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= maxTokenValue; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        Random random = new Random();
        for(int i = 0; i<= initialTokens; ++i) {
            tokens.add(new Token(numbers.get(i).intValue(),random.nextBoolean()));
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void addToken(Token token) {
        this.tokens.add(token);
    }

    public void removeToken(Token token) {
        this.tokens.remove(token);
    }
}
