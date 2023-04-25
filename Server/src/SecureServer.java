import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class SecureServer {
    static final int PORT = 10102;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        String securityPolicyUrl = "file:G:/My%20Drive/School/20503%20-%20Advanced%20Java%20Workshop/" +
                "RMI_security_example/Server/server.policy";  // Security policy URL

        /* Set some system properties */
        System.setProperty("java.security.policy", securityPolicyUrl);  // Specify security policy
        System.setProperty("java.rmi.server.useCodebaseOnly", "false"); // Allow to dynamically download classes

        /* Create a security manager */
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        /* Initialize server like before */
        LocateRegistry.createRegistry(PORT);          // Create RMI Registry
        Compute computeEngine = new ComputeEngine();  // Instantiate remote object
        Compute stub =
                (Compute) UnicastRemoteObject.exportObject(computeEngine, 0);  // Export object
        LocateRegistry.getRegistry(PORT).bind("Compute", stub);               // Bind stub
        System.out.println("Server setup is successful");
    }
}
