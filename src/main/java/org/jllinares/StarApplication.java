package org.jllinares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class StarApplication.
 * @author Javier Llinares
 */
@SpringBootApplication
public class StarApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("----------------------------->>>>>>>>>>>> Aplicacion Iniciando");
		SpringApplication.run(StarApplication.class, args);
		System.out.println("----------------------------->>>>>>>>>>>> Aplicacion Iniciada");
	}
}
