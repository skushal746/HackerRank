package practice.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = scr.nextInt();
		System.out.println(maxMin(k, arr));
		scr.close();
	}
	
	static int maxMin(int k, int[] arr) {
		int minimumUnfairness = 0;
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length-k+1;i++)
		{
			if(i==0)
				minimumUnfairness = arr[i+k-1]-arr[i];
			else if((arr[i+k-1]-arr[i])<minimumUnfairness)
			{
				minimumUnfairness = arr[i+k-1]-arr[i];
				System.out.println(arr[i+k-1]+ " " + arr[i] + " " + i);
			}
			
		}
		
		return minimumUnfairness;
    }
}
