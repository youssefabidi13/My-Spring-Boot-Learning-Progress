package myEssay;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MyAPP {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Abidi youssef = context.getBean("myAbidi",Abidi.class);
	}

}
