package cn.edu.nju.sa2017.di;

public class HelloWorld {

	private String message;
	private Printer printer;

	public HelloWorld(Printer printer){
		this.printer=printer;
		
	}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void hello(){
		printer.printMessage(this.getMessage());
	}
}
