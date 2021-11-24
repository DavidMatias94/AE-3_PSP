package serviciorest;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//AQUÍ ARRANCARÁ NUESTRA APLICACIÓN 
//CON LA ANOTACIÓN @SpringBootApplication HACEMOS QUE SPRINGBOOT:
//1. BUSQUE ANOTACIONES .
//2. SE AUTOCONFIGURE
//3. BUSCA METODOS CON @BEAN

@SpringBootApplication
public class Application {	
	
	public static void main(String[] args) {
		System.out.println("Servicio Rest -> El contexto de Spring se está cargando, espere unos instantes....");
		//CON EL MÉTODO RUN ARRANCAREMOS EL CONTEXTO SPRING
		SpringApplication.run(Application.class, args);
		System.out.println("Servicio Rest -> Contexto de Spring cargado!");
	}
}
