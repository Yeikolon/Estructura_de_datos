package model;

public class ExpressionPrefix {
    
  
    public static int hierarchyInside(char operator) {
        int value;
        switch(operator) {
        case '^':
            value = 3;
            break;
        case '*': case '/':
            value = 2;
            break;
        case '+': case '-':
            value = 1;
            break;
        case '(':
            value = 0;
        default:
            value = -1;
        }
        return value;
    }
    
    public static int hierarchyOutside(char operator) {
        int value;
        switch(operator) {
        case '^':
            value = 4;
            break;
        case '*': case '/':
            value = 2;
            break;
        case '+': case '-':
            value = 1;
            break;
        case '(':
            value = 5;
        default:
            value = -1;
        }
        return value;
    }
    
  
    public static String prefix(String infixExpression) throws Exception {
        
        String invertExpression = imvertExpression(infixExpression);
        
     
        String invertPostfix = invertPostfix(invertExpression);
        
       
        return imvertExpression(invertPostfix);
    }
    
    private static String imvertExpression(String expression) {
        StringBuilder invert = new StringBuilder();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == '(') {
                invert.append(')');
            } else if (c == ')') {
                invert.append('(');
            } else {
                invert.append(c);
            }
        }
        
        return invert.toString();
    }
    
    private static String invertPostfix(String infixExpression) throws Exception {
        StackList pile = new StackList();
        char[] expression = new char[infixExpression.length()];
        int n = 0;
        
        for (int i = 0; i < infixExpression.length(); i++) {
            char caracter = infixExpression.charAt(i);
            
            if (caracter == ' ') {
                continue;
            }
            
            if (Character.isLetter(caracter)) {
                expression[n++] = caracter;
            } else if (caracter == '^' || caracter == '*' || caracter == '/' ||
                      caracter == '+' || caracter == '-') {
                while (true) {
                    if (pile.emptyPile()) {
                        pile.pushPila(caracter);
                        break;
                    } else {
                        char cima = (Character) pile.cimePile2();
                        
                        if (hierarchyOutside(caracter) > hierarchyInside(cima)) {
                            pile.pushPila(caracter);
                            break;
                        } else {
                            char operadorPila = (Character) pile.popPila();
                            expression[n++] = operadorPila;
                        }
                    }
                }
            } else if (caracter == '(') {
                pile.pushPila(caracter);
            } else if (caracter == ')') {
                while (true) {
                    char operadorPila = (Character) pile.popPila();
                    
                    if (operadorPila == '(') {
                        break;
                    } else {
                        expression[n++] = operadorPila;
                    }
                }
            }
        }
        
        while (!pile.emptyPile()) {
            char operadorPila = (Character) pile.popPila();
            expression[n++] = operadorPila;
        }
        
        return new String(expression, 0, n);
    }
}