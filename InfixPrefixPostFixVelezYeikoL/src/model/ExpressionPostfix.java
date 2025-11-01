package model;

public class ExpressionPostfix {
	
	//Jerarquia dentro de la pila
	public static int hierarchyInside(char operator) {
		int value;
		switch(operator) {
		case '^':
			value = 3;
			break;
		case '*':case '/':
			value = 2;
			break;
		case '+':case '-':
			value = 1;
			break;
		case '(':
			value = 0;
			default:
				value = -1;
		}
		return value;
	}
	
	//Jerarquia fuera de la pila
		public static int hierarchyOutside(char operador) {
			int value;
			switch(operador) {
			case '^':
				value = 4;
				break;
			case '*':case '/':
				value = 2;
				break;
			case '+':case '-':
				value = 1;
				break;
			case '(':
				value = 5;
				default:
					value = -1;
			}
			return value;
		}
		
		//Conversion
		public static String postfix(String infixExpression) throws Exception{
			StackList pile = new StackList();
			char[] expression = new char[infixExpression.length()];
			int n = 0;
			
			for(int i = 0; i < infixExpression.length(); i++) {
				char caracter = infixExpression.charAt(i);
				
				if(caracter == ' ') {
					continue;
				}
				
				if(Character.isLetter(caracter)) {
					expression[n++] = caracter;
				}else if(caracter == '^' || caracter == '*' || caracter == '/'
						|| caracter == '+' || caracter == '-') {
					while(true) {
						if(pile.emptyPile()) {
							pile.pushPila(caracter);
							break;
						}else {
							char cime = (Character) pile.cimePile2();
							
							if(hierarchyOutside(caracter) > hierarchyInside(cime)) {
								pile.pushPila(caracter);
								break;
							}else {
								char operadorPila = (Character)pile.popPila();
								expression[n++] = operadorPila;
							}
						}
					}
				}else if(caracter == '(') {
					pile.pushPila(caracter);
				}else if(caracter == ')') {
					while(true) {
						char operatorPile = (Character)pile.popPila();
						
						if(operatorPile == '(') {
							break;
						}else {
							expression[n++] = operatorPile;
						}
					}
				}
				
			}
			
			while(!pile.emptyPile()) {
				char operatorPile = (Character) pile.popPila();
				expression[n++] = operatorPile;
			}
			
			return new String(expression, 0 , n);
		}
	
}
