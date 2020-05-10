package practice.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlmostSorted {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int[] arr = new int[n];
		almostSorted(arr);
		scr.close();
	}
	
	static void almostSorted(int[] arr) {
		List<Integer> downHillPoints = new ArrayList<Integer>();
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i+1] < arr[i])
				downHillPoints.add(i);
		}
		
		
	}
}
