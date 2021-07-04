import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class GameClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry();
        Game game = (Game) registry.lookup("Game");

        String serverGreeting = game.greet();
        System.out.println(serverGreeting);

        do {

            GameOptions choice = GameImpl.randomChoice();
            System.out.println("You chose " + choice);
            String result = game.getResult(choice);
            System.out.println(result);

        } while (playAgain());

    }

    private static boolean playAgain() {

        Scanner scanner = new Scanner(System.in);
        int number;

        do {

            System.out.println();
            System.out.println("Press 1 to play again or 2 to exit.");
            number = scanner.nextInt();

        } while (number != 1 && number != 2);

        if (number == 2) {
            return false;
        }

        return true;
    }
}