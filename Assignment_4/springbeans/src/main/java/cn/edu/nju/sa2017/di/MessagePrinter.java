package cn.edu.nju.sa2017.di;

public class MessagePrinter implements Printer {

		public void printMessage(String message){
			System.out.println("\t $" + message  +"");
		}
}
