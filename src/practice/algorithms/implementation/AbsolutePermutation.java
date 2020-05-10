package practice.algorithms.implementation;

import java.util.Scanner;

public class AbsolutePermutation {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCase = scr.nextInt();
		for(int i=0;i<testCase;i++)
		{
			int n = scr.nextInt();
			int k = scr.nextInt();
			int[] output = absolutePermutation(n, k);
			for(int j=0;j<output.length;j++)
				System.out.print(output[j] + " ");
			System.out.println();
		}
		
		scr.close();
	}
	
	static int[] absolutePermutation(int n, int k) {
		int[] tracker = new int[n];
		int[] result = new int[n];
		for(int i=0;i<n;i++)
		{
			
			if(i-k>=0 && i-k<n && tracker[i-k]!=-1)
			{
				result[i] = i-k+1;
				tracker[i-k]=-1;
			}
			else if(i+k>=0 && i+k<n && tracker[i+k]!=-1)
			{
				result[i] = i+k+1;
				tracker[i+k]=-1;
			}
			else
			{
				result = new int[1];
				result[0]=-1;
				return result;
			}
		}
		return result;
    }
	
}
