package practice.algorithms.implementation;

import java.util.Scanner;

public class LisaWorkbook {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = scr.nextInt();
		}
		
		System.out.println(workbook(n, k, arr));
		
		scr.close();
	}
	
	static int workbook(int n, int k, int[] arr) {

		int pageNumber = 1;
		int specialProblem = 0;
		
		for(int i=0;i<n;i++)
		{
			int numberOfproblems = arr[i];
			int startProblemNumber = 1;
			int endProblemNumber = (numberOfproblems>k)?k:numberOfproblems;
			while(endProblemNumber <= numberOfproblems && startProblemNumber <=numberOfproblems)
			{
				if(pageNumber>=startProblemNumber&&pageNumber<=endProblemNumber)
				{
					specialProblem++;
				}
				pageNumber++;
				startProblemNumber = endProblemNumber+1;
				endProblemNumber = (endProblemNumber+k<numberOfproblems)?(endProblemNumber+k):numberOfproblems;
			}
		}
		
		return specialProblem;
    }
	
}
