import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Service.Calculator;
import Service.CalculatorImpl;

public class Server {
	public static void main(String[] args) {
		final int PORT = 1099; // RMI port
		try {
			Calculator skeleton = (Calculator) UnicastRemoteObject.exportObject(new CalculatorImpl(), 0); // Creating a skeleton
			Registry reg = LocateRegistry.getRegistry(PORT); // Creating a registry
			reg.rebind("Calculator", skeleton); // (Re)binding a skeleton under the "Calculator" name
			System.out.println("Uploaded a calculator");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
