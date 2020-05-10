package practice.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int cCount = scr.nextInt();
		int[] c = new int[cCount];
		for(int i=0;i<cCount;i++)
			c[i]=scr.nextInt();
		System.out.println(flatlandSpaceStations(n, c));
		scr.close();
	}
	
	static int flatlandSpaceStations(int n, int[] c) {
		
		if(n==1)
			return 0;
		
		if(c.length == 1)
		{
			if(c[0] > (n-1-c[0]))
				return c[0];
			else return n-1-c[0];
		}
		
		Arrays.sort(c);
		int longestDistanceToSpaceStation = 0;
		for(int i=0;i<c.length;i++)
		{
			int distanceBetween = 0;
			if(i==0)
			{
				longestDistanceToSpaceStation = c[i];
				distanceBetween = (c[i+1]-c[i])/2;
				if(distanceBetween>longestDistanceToSpaceStation)
					longestDistanceToSpaceStation = distanceBetween;
			}
			else if(i==c.length-1)
			{
				if((n-1-c[c.length-1])>longestDistanceToSpaceStation)
					longestDistanceToSpaceStation = n-1-c[c.length-1];
			}
			else
			{
				distanceBetween = (c[i+1]-c[i])/2;
				if(distanceBetween>longestDistanceToSpaceStation)
					longestDistanceToSpaceStation = distanceBetween;
			}
		}
		return longestDistanceToSpaceStation;
    }
	
}
