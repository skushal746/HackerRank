package practice.algorithms.dynamicprogramming;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int t1 = scr.nextInt();
		int t2 = scr.nextInt();
		int n = scr.nextInt();
		
		System.out.println(fibonacciModified(t1, t2, n));
		
		
	}
	
	static String fibonacciModified(int t1, int t2, int n) {
		
		BigInteger t1bg = new BigInteger(String.valueOf(t1));
		BigInteger t2bg = new BigInteger(String.valueOf(t2));
		
		for(int i=0;i<n-2;i++)
		{
			BigInteger temp = t1bg.add(t2bg.pow(2));
			t1bg = t2bg;
			t2bg = temp;
			//System.out.println(t2bg.toString());
		}
			
		return t2bg.toString();
    }
}
