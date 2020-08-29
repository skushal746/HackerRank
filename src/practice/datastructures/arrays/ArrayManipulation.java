package practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulation {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int n = scr.nextInt();
		int m = scr.nextInt();
		
		int[][] queries = new int[m][3];
		
		for(int i=0;i<m;i++)
		{
			queries[i][0] = scr.nextInt();
			queries[i][1] = scr.nextInt();
			queries[i][2] = scr.nextInt();
		}
		
		System.out.println(arrayManipulation(n, queries));
	}
	
	static long arrayManipulation(int n, int[][] queries) {
		List<long[]> tracker = new ArrayList<long[]>();
		long highestElement = 0;
		
		for(int i=0;i<queries.length;i++)
		{
			if(tracker.size()==0)
			{
				tracker.add(new long[] {queries[0][0], queries[0][1], queries[0][2]});
				highestElement = queries[0][2];
			}
			
		}
		return 0;
    }
}
