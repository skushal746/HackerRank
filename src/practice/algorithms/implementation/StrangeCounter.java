package practice.algorithms.implementation;

import java.util.Scanner;

public class StrangeCounter {

	static long strangeCounter(long t) {
		
		long n = (long) Math.ceil(Math.log((double)t/3 + 1)/Math.log(2));
		
		//System.out.println(n);
		
		long highestNumber = (long) (3*(Math.pow(2, n)-1));
		
		
		return 1 + (highestNumber - t);
    }
	
	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		int t = scr.nextInt();
		System.out.println(strangeCounter(t));
		scr.close();
	}
	
}
