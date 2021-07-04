import java.rmi.RemoteException;

public class GameImpl implements Game {

    @Override
    public String greet() throws RemoteException {
        return "Welcome to Rock-Paper-Scissors game! You play first.";
    }

    @Override
    public String getResult(GameOptions choice) throws RemoteException {
        GameOptions serverChoice = this.randomChoice();
        GameOptions clientChoice = choice;
        GameResult result = GameReferee.getResult(serverChoice, clientChoice);

        return announceResult(serverChoice, result);
    }

    protected static GameOptions randomChoice() {
        return new GameChoice().randomChoice();
    }

    private String announceResult(GameOptions serverChoice, GameResult result) {

        String message = result.equals(GameResult.DRAW) ?
                String.format("Server chose %s. *** Result is DRAW", serverChoice) :
                String.format("Server chose %s. *** Winner is %s", serverChoice, result);

        return message;
    }
}
