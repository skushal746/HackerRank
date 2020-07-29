package practice.algorithms.greedy;

import java.util.Scanner;

public class GreedyFlorist {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int n = scr.nextInt();
		int k = scr.nextInt();
		
		int[] c =new int[n];
		
		for(int i=0;i<n;i++)
			c[i] = scr.nextInt();
		
		System.out.println(getMinimumCost(k, c));
		
		scr.close();
	}
	
	static int getMinimumCost(int k, int[] c) {
		int[] trackOfPrice = new int[1000001];
		int maximumNumber = 0;
		for(int i=0;i<c.length;i++)
		{
			trackOfPrice[c[i]]++;
			if(c[i]>maximumNumber)
				maximumNumber = c[i];
		}
		//System.out.println(maximumNumber);
		
		int totalPrice = 0;
		
		int kRemaining = k;
		int multiplier = 1;
		
		for(int i=maximumNumber;i>=0;i--)
		{
			if(trackOfPrice[i]>0)
			{
				//System.out.println(totalPrice);
				if(kRemaining!=0)
				{
					totalPrice += i*multiplier;
					kRemaining--;
				}
				else
				{
					kRemaining = k;
					multiplier++;
					totalPrice += i*multiplier;
					kRemaining--;
				}
			}
		}
        
		return totalPrice;
    }
}
