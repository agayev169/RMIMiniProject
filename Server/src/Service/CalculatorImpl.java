package Service;

import java.rmi.RemoteException;

public class CalculatorImpl implements Calculator {

	@Override
	public int solveExpression(String expression) throws RemoteException {
		int first = getNum(expression); // Get the first number
        expression = deleteNum(expression); // Delete the first number from the expression
        char oper = getOperator(expression); // Get the operator (+, -, *, /)
        int second = getNum(expression); // Get the second number

        int res = -1; // Initializing a default value of the result
        switch (oper) {
            case '+':
                res = first + second;
                break;
            case '-':
                res = first - second;
                break;
            case '*':
                res = first * second;
                break;
            case '/':
                if (second == 0) return res; // If we have division by 0 return -1
                res = first / second;
                break;
        }
        return res;
	}

	@Override
	public int getNum(String expression) throws RemoteException {
		int res = 0; // Initializing the result
        int i = 0; // Counter
        while (expression.toCharArray()[i] < '0' || expression.toCharArray()[i] > '9') { // Skip everything till the first digit
            i++;
        }
        for (; i < expression.length() && expression.toCharArray()[i] >= '0' &&
                expression.toCharArray()[i] <= '9'; i++) { // Loop to get the number
            res = res * 10 + expression.toCharArray()[i] - '0';
        }
        return res;
	}

	@Override
	public char getOperator(String expression) throws RemoteException {
		char res; // Initializing the result
        int i = 0; // Counter
        while (i < expression.length() && expression.toCharArray()[i] != '+' &&
                expression.toCharArray()[i] != '-' && expression.toCharArray()[i] != '/' &&
                expression.toCharArray()[i] != '*') { // Skip everything till the operator
            i++;
        }
        res = expression.toCharArray()[i]; // Save an operator as the result
        return res;
	}

	@Override
	public String deleteNum(String expression) throws RemoteException {
		String newExpression = ""; // newExpression that will be like expression but without first number
        int i = 0; // Counter
        while (i < expression.length() && expression.toCharArray()[i] >= '0' &&
                expression.toCharArray()[i] <= '9') { // Skip everything till the end of the first number
            i++;
        }
        for (; i < expression.length(); i++) { // Loop to save expression without the first number
            newExpression += expression.toCharArray()[i];
        }
        return newExpression;
	}
	
}
