package practice.algorithms.implementation;

import java.util.Scanner;

public class FairRations {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int[] B = new int[n];
		for(int i=0;i<n;i++)
			B[i]=scr.nextInt();
		System.out.println(fairRations(B));
	}
	
	static Object fairRations(int[] B) {
		int loavesDistributed = 0;
		for(int i=0;i<B.length;i++)
		{
			if(i==B.length-1)
				if(B[i]%2!=0)
				{
					System.out.println("NO");
					return "NO";
				}
			if(B[i]%2!=0)
			{
				B[i]++;
				B[i+1]++;
				loavesDistributed+=2;
			}
		}
		return loavesDistributed;
    }
}
