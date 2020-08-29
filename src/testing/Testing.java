package testing;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Testing {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
        Animal animal = new Animal();
        System.out.println(animal instanceof Dog);
        System.out.println(animal instanceof Cat);
        System.out.println(animal instanceof Animal);
        animal.run();
        animal = new Dog();
        System.out.println(animal instanceof Dog);
        System.out.println(animal instanceof Cat);
        System.out.println(animal instanceof Animal);
        animal.run();
        animal = new Cat();
        System.out.println(animal instanceof Dog);
        System.out.println(animal instanceof Cat);
        System.out.println(animal instanceof Animal);
        animal.run();
        
	}
	
}
