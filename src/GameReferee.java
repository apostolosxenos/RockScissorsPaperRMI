public class GameReferee {

    public static GameResult getResult(GameOptions serverChoice, GameOptions clientChoice) {
        return (serverChoice == clientChoice) ? GameResult.DRAW : isClientWinner(serverChoice, clientChoice) ? GameResult.CLIENT : GameResult.SERVER;
    }

    private static boolean isClientWinner(GameOptions serverChoice, GameOptions clientChoice) {
        return (clientChoice.isRock() && serverChoice.isScissors() ||
                clientChoice.isPaper() && serverChoice.isRock() ||
                clientChoice.isScissors() && serverChoice.isPaper());
    }
}
