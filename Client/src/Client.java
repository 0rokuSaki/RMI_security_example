import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    static final String HOST_ADDR = "localhost";
    static final int HOST_PORT = 10102;

    public static void main(String[] args) throws RemoteException, NotBoundException {

        String codeBaseUrl = "file:G:/My%20Drive/School/20503%20-%20Advanced%20Java%20Workshop/" +
                "RMI_security_example/Client/out/production/Client/";  // Code base URL

        System.setProperty("java.rmi.server.codebase", codeBaseUrl);   // Allow server to download class

        Registry registry = LocateRegistry.getRegistry(HOST_ADDR, HOST_PORT);  // Locate server's registry
        Compute stub =
                (Compute) registry.lookup("Compute");  // Obtain a reference to the remote object
        // Invoke methods on the remote object
        Task<Integer> hardTask = new HardTask();
        Integer result = stub.executeTask(hardTask);
        System.out.println("Calculation result is: " + result);
    }
}
