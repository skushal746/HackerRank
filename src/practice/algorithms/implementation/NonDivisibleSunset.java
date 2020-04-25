package practice.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonDivisibleSunset {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		
		List<Integer> s = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			s.add(scr.nextInt());
		
		System.out.println(nonDivisibleSubset(k, s));
		scr.close();
	}
	
	public static int nonDivisibleSubset(int k, List<Integer> s) {
	    // Write your code here
		
		List<Integer> modOfTheElementsCountArray = new ArrayList<Integer>();
		
		if(k==1)
		{
			return 1;
		}
		
		for(int i=0;i<k;i++)
				modOfTheElementsCountArray.add(0);
		
		for(int i=0;i<s.size();i++)
		{
			int count = modOfTheElementsCountArray.get(s.get(i)%k);
			modOfTheElementsCountArray.add(s.get(i)%k, count+1);
			modOfTheElementsCountArray.remove(s.get(i)%k+1);
		}
		int sizeOfTheBiggestArray = 0;
		for(int i=1;i<modOfTheElementsCountArray.size()/2+1;i++)
		{
			if(i==modOfTheElementsCountArray.size()/2 && modOfTheElementsCountArray.size()%2==0)
			{
				if(modOfTheElementsCountArray.get(modOfTheElementsCountArray.size()/2)>0)
					sizeOfTheBiggestArray++;
			}
			else if(i==modOfTheElementsCountArray.size()/2 && modOfTheElementsCountArray.size()%2!=0)
			{
				int countToBeAdded = modOfTheElementsCountArray.get(i)>modOfTheElementsCountArray.get(k-i)?modOfTheElementsCountArray.get(i):modOfTheElementsCountArray.get(k-i);
				sizeOfTheBiggestArray = sizeOfTheBiggestArray + countToBeAdded;
			}
			else
			{
				int countToBeAdded = modOfTheElementsCountArray.get(i)>modOfTheElementsCountArray.get(k-i)?modOfTheElementsCountArray.get(i):modOfTheElementsCountArray.get(k-i);
				sizeOfTheBiggestArray = sizeOfTheBiggestArray + countToBeAdded;
			}
		}
		if(modOfTheElementsCountArray.get(0)>0)
			sizeOfTheBiggestArray++;
		
		return sizeOfTheBiggestArray;
	}
}
