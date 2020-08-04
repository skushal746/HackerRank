package practice.algorithms.dynamicprogramming;

import java.util.Scanner;

public class TheMaximumSubarray {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCase = scr.nextInt();
		for(int i=0;i<testCase;i++)
		{
			int n = scr.nextInt();
			int[] arr = new int[n];
			for(int j=0;j<n;j++)
				arr[j] = scr.nextInt();
			int[] output = maxSubarray(arr);
			
			for(int j=0;j<output.length;j++)
				System.out.print(output[j]+" ");
			
			System.out.println();
			
		}
	}
	
	static int[] maxSubarray(int[] arr) {
		
		int highestSubArray = -999999999;
		
		int[] computation = new int[arr.length];
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length-i;j++)
			{
				if(i==0)
				{
					computation[j] = arr[j];
					if(computation[j]>highestSubArray)
						highestSubArray = computation[j];
				}
				else
				{
					computation[j] = computation[j] + arr[j+i];
					if(computation[j]>highestSubArray)
						highestSubArray = computation[j];
				}
			}
		
		int highestSubSequence = 0;
		boolean anyZeroElement=false;
		int highestNegativeElement=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
				anyZeroElement=true;
			if(arr[i]<0 && highestNegativeElement<arr[i])
				highestNegativeElement = arr[i];
			if(arr[i]>0)
				highestSubSequence+=arr[i];
		}
		
		if(!anyZeroElement && highestSubSequence==0)
			highestSubSequence=highestNegativeElement;
		
		
		
		return new int[]{highestSubArray, highestSubSequence};
    }
}
