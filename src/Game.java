import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Game extends Remote {

    String greet() throws RemoteException;
    String getResult(GameOptions choice) throws RemoteException;
}
