package njuics.demos.springbeans;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogPrinter implements Printer {

	public void printMessage(String message) {

		Logger.getLogger(this.getClass().getName()).log(Level.INFO, message);
	}
}
