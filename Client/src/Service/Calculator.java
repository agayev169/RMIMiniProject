package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	// A method to solve a given expression
	public int solveExpression(String expression) throws RemoteException;
	
	// A method to get a (first) number from a given expression
	public int getNum(String expression) throws RemoteException;
	
	// A method to get a (first) operator from a given expression
	public char getOperator(String expression) throws RemoteException;
	
	// A method to delete a (first) number from a given expression
	public String deleteNum(String expression) throws RemoteException;
}
