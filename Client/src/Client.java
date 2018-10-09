import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Service.Calculator;

public class Client {
	public static void main(String[] args) {
		final int PORT = 1099; // RMI port
		Scanner sc = new Scanner(System.in); // Scanner to scan the expression from the user
		System.out.print("Expression to solve: ");
		String expression = sc.nextLine(); // Expression itself
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", PORT); // Creating registry
			Calculator calc = (Calculator) reg.lookup("Calculator"); // Downloading a calculator
			System.out.println(expression + " = " + calc.solveExpression(expression)); // Solving an expression and 
			// printing the result
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
