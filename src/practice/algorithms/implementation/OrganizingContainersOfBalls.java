package practice.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrganizingContainersOfBalls {
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int q = scr.nextInt();
		for(int i=0;i<q;i++)
		{
			int n = scr.nextInt();
			int[][] container = new int[n][n];
			for(int j=0;j<n;j++)
				for(int k=0;k<n;k++)
					container[j][k]=scr.nextInt();
			System.out.println(organizingContainers(container));
		}
		scr.close();
	}
	
	static String organizingContainers(int[][] container) {
		int n = container.length;
		List<Integer> containersNeedsSorting = new ArrayList<Integer>();
		for(int j=0;j<n;j++)
		{
			boolean followingContainerPerfect = true;
			for(int k=0;k<n;k++)
			{
				if(container[j][k] != 0 && j!=k)
					followingContainerPerfect = false;
			}
			if(!followingContainerPerfect)
				containersNeedsSorting.add(j);
		}
		
		for(Integer rowNeedsSorting : containersNeedsSorting)
		{
			
			for(int i=0;i<n;i++)
			{
				
			}
		}
		
		return "";
    }

}
