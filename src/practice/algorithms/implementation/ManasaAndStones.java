package practice.algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManasaAndStones {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCase = scr.nextInt();
		for(int i=0;i<testCase;i++)
		{
			int n = scr.nextInt();
			int a = scr.nextInt();
			int b = scr.nextInt();
			int[] lastStoneValue = stones(n, a, b);
			for(int j=0;j<lastStoneValue.length;j++)
				System.out.print(lastStoneValue[j] + " ");
			System.out.println();
		}
		scr.close();
	}
	
	static int[] stones(int n, int a, int b) {
		List<Integer> currentStoneProbableValues = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(i==0)
				currentStoneProbableValues.add(0);
			else
			{
				List<Integer> nextStoneProbableValue = new ArrayList<Integer>();
				for(Integer oneOfTheValues : currentStoneProbableValues)
				{
					if(!nextStoneProbableValue.contains(oneOfTheValues + a))
						nextStoneProbableValue.add(oneOfTheValues + a);
					if(!nextStoneProbableValue.contains(oneOfTheValues + b))
						nextStoneProbableValue.add(oneOfTheValues + b);
				}
				currentStoneProbableValues = new ArrayList<Integer>();
				currentStoneProbableValues.addAll(nextStoneProbableValue);
				if(currentStoneProbableValues.contains(0))
					currentStoneProbableValues.remove(0);
			}
		}
		Object[] resultObjectForm = currentStoneProbableValues.toArray();
		int[] result = new int[resultObjectForm.length];
		for(int i=0;i<resultObjectForm.length;i++)
			result[i] = Integer.parseInt(String.valueOf(resultObjectForm[i]));
		Arrays.sort(result);
		return result;
    }
}
