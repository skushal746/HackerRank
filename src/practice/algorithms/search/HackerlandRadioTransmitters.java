package practice.algorithms.search;

import java.util.Scanner;

public class HackerlandRadioTransmitters {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++)
		{
			x[i] = scr.nextInt();
		}
		System.out.println(hackerlandRadioTransmitters(x, k));
		scr.close();
	}
	
	static int hackerlandRadioTransmitters(int[] x, int k) {
		int minimumLocation = 100000;
		int maximumLocation = 0;
		int[] locationOfHouses = new int[200010];
		for(int i=0;i<x.length;i++)
		{
			if(x[i]<minimumLocation)
				minimumLocation = x[i];
			if(x[i]>maximumLocation)
				maximumLocation = x[i];
			locationOfHouses[x[i]]++;
		}
		int currentLocation = minimumLocation;
		int numberOfTransmitters = 0;
		while(true)
		{
	
			if(currentLocation > maximumLocation)
				break;
			
			if(locationOfHouses[currentLocation]==0)
			{
				while(locationOfHouses[currentLocation]==0)
					currentLocation++;
			}
			
			
			if(locationOfHouses[currentLocation+k]>0)
			{
				numberOfTransmitters++;
				currentLocation = currentLocation + 2*k + 1;
			}
			else
			{
				for(int j=currentLocation+k;j>=currentLocation;j--)
				{
					if(locationOfHouses[j]>0)
					{
						numberOfTransmitters++;
						currentLocation = j + k + 1;
						break;
					}
				}
			}
		}
		
		return numberOfTransmitters;
    }	
}
