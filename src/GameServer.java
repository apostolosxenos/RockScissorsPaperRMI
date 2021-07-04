import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GameServer {

    public static void main(String[] args) {

        try {

            Game gameServer = new GameImpl();
            Game stub = (Game) UnicastRemoteObject.exportObject((Game) gameServer, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Game", stub);

            System.out.println("Server ready...");

        } catch (RemoteException re) {
            System.err.println("Server exception: " + re.toString());
            re.printStackTrace();
        }
    }
}