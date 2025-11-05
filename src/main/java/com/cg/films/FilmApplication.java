package com.cg.films;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class FilmApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(FilmApplication.class, args);
		System.out.println("Film Rental Application started!");
 
	}
 
}