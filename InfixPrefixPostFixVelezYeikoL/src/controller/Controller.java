package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import model.EvaluationPostfix;
import model.ExpressionPostfix;
import model.ExpressionPrefix;
import view.View;

public class Controller implements ActionListener {
    
    private View view;
    private Map<Character, Double> varialVals;
    
    public Controller(View view) {
        this.view = view;
        this.varialVals = new HashMap<>();
        events();
    }
    
    private void events() {
        view.getBtnConvertir().addActionListener(this);
        view.getBtnLimpiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnConvertir()) {
            convertExpression();
        } else if (e.getSource() == view.getBtnLimpiar()) {
            clean();
        }
    }
    
    private void convertExpression() {
        try {
            String infixExpressio = view.getTextFieldInfija().getText().trim();
            
            if (infixExpressio.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Enter one infix expression", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
           
            String postInfixExpression = ExpressionPostfix.postfix(infixExpressio);
            view.getTextFieldPostfija().setText(postInfixExpression);
            
           
            String prefixExpression = ExpressionPrefix.prefix(infixExpressio);
            view.getTextFieldPrefija().setText(prefixExpression);
      
            getValuesVarials(postInfixExpression);
            
         
            double result = EvaluationPostfix.test(postInfixExpression, getArrayValues());
            view.getTextFieldResultado().setText(String.valueOf(result));
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error in the expression: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void getValuesVarials(String expresion) {
        varialVals.clear();
        
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (Character.isLetter(c) && !varialVals.containsKey(c)) {
                String valorStr = JOptionPane.showInputDialog(view, 
                    "Enter value for variable '" + c + "':", 
                    "Value of variable", 
                    JOptionPane.QUESTION_MESSAGE);
                
                if (valorStr == null) {
                    throw new RuntimeException("Operation dimiss for the user");
                }
                
                try {
                    double value = Double.parseDouble(valorStr);
                    varialVals.put(c, value);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view, "Value invalid for '" + c + "'. It must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException("Value invalid for variable " + c);
                }
            }
        }
    }
    
    private double[] getArrayValues() {
        double[] valuesArray = new double[26];
        for (Map.Entry<Character, Double> entry : varialVals.entrySet()) {
            int index = entry.getKey() - 'a';
            if (index >= 0 && index < 26) {
                valuesArray[index] = entry.getValue();
            }
        }
        return valuesArray;
    }
    
    private void clean() {
        view.getTextFieldInfija().setText("");
        view.getTextFieldPostfija().setText("");
        view.getTextFieldResultado().setText("");
        view.getTextFieldPrefija().setText("");
        varialVals.clear();
    }
}