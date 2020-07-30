package practice.algorithms.constructuvealgorithms;

import java.util.Scanner;

public class NewYearChaos {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int testCase = scr.nextInt();
		for(int i=0;i<testCase;i++)
		{
			int n = scr.nextInt();
			int[] q = new int[n];
			for(int j=0;j<n;j++)
				q[j] = scr.nextInt();
			
			minimumBribes(q);
		}
		
	}
	
	static void minimumBribes(int[] q) {

		int[] bribeTracker = new int[q.length + 1];
		int totalBribery = 0;
		for(int i=0;i<q.length;i++)
		{
			if(q[i]==i+1)
				continue;
			
			int findPlace =0;
			for(int j=i+1;j<q.length;j++)
				if(q[j]==i+1)
				{
					findPlace=j;
					break;
				}
		
			
			for(int j=findPlace;j>i;j--)
			{
				q[j]=q[j-1];
				if(bribeTracker[q[j]]==2)
				{
					System.out.println("Too chaotic");
					return;
				}
				bribeTracker[q[j]]++;
				totalBribery++;
			}
			q[i]=i+1;
		}
		
		System.out.println(totalBribery);
		
    }
	
}
