import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    static final int PORT = 10102;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        LocateRegistry.createRegistry(PORT);          // Create RMI Registry
        Compute computeEngine = new ComputeEngine();  // Instantiate remote object
        Compute stub =
                (Compute) UnicastRemoteObject.exportObject(computeEngine, 0);  // Export object
        LocateRegistry.getRegistry(PORT).bind("Compute", stub);               // Bind stub
        System.out.println("Server setup is successful");
    }
}
