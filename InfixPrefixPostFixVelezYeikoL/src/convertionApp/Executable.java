package convertionApp;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.Controller;
import model.EvaluationPostfix;
import model.ExpressionPostfix;
import view.View;

public class Executable {

		public static void main(String[] args) {
			 EventQueue.invokeLater(new Runnable() {
			        public void run() {
			            try {
			                View frame = new View();
			               
			                new Controller(frame);
			                frame.setVisible(true);
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
			    });
		}
}


