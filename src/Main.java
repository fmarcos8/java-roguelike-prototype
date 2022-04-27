import com.engine.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();

        Thread thread = new Thread(game);
        thread.start();
    }
}
