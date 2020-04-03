package compulsory;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(20,12,4);
        Player player = new Player("P", game);
        Player player1 = new Player("P1", game);
        game.play();
    }
}
