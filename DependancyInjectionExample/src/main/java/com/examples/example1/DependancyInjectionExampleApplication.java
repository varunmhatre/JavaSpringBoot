package com.examples.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependancyInjectionExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependancyInjectionExampleApplication.class, args);

		Alien a = context.getBean(Alien.class);
		a.getLaptop().setBrand("HP");
		
		a.show();
		
		Alien a2 = context.getBean(Alien.class);
		
		a2.show();		

		System.out.println("a1 Laptop = " + a.getLaptop());
		System.out.println("a2 Laptop = " + a2.getLaptop());
		System.out.println("a1 Device = " + a.getDevice());
		System.out.println("a2 Device = " + a2.getDevice());
}

}
