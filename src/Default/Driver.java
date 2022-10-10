package Default;

public class Driver {
    public static void main(String[] args) throws Exception {
        System.out.println("\n***=== Welcome to the board games arena ===***\n");

        GameSelector gameSelector = new GameSelector();
        gameSelector.show();
    }
}
