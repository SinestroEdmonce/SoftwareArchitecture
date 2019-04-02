package cn.edu.nju.sa2017.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"Bean.xml");

		try {
			HelloWorld helloW = (HelloWorld) context.getBean("helloWorldBean");
			helloW.hello();

		} finally {
			context.close();
		}

	}
}
