package cn.edu.nju.sa2017.di;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogPrinter implements Printer {

	public void printMessage(String message) {

		Logger.getLogger(this.getClass().getName()).log(Level.INFO, message);
	}
}
