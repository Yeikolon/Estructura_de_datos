package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvaluationPostfix {

	//Obtener indices
	public static void index(String expression, double[] values)throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if(Character.isLetter(c)) {
				int index = c - 'a';
				if(values[index] == 0) {
					System.out.println("Valor para "+c + ": ");
					String valorStr = input.readLine();
					values[index] = Double.parseDouble(valorStr);
				}
			}
		}
	}
	
	//Evaluar expresion postfija
	public static double test(String expression, double[] values) throws Exception{
		StackList pile = new StackList();
		
		for(int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			
			if(Character.isLetter(c)) {
				int index = c - 'a';
				pile.pushPila(values[index]);
			}else {
				double b = (Double)pile.popPila();
				double a = (Double)pile.popPila();
				double result = 0;
				switch(c) {
				case '^': result = Math.pow(a, b);break;
				case '*': result = a*b; break;
				case '/': result = a/b;break;
				case '+': result = a + b; break;
				case '-': result = a -b; break;
				}
				
				pile.pushPila(result);
			}
		}
		
		return (Double) pile.popPila();
	}

}
