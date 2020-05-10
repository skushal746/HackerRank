package practice.algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LilyHomework {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = scr.nextInt();

		System.out.println(lilysHomework(arr));
		scr.close();
	}

	static int lilysHomework(int[] arr) {
		Map<Integer,Integer> integerAndItsPosition = new HashMap<Integer, Integer>();
		Map<Integer,Integer> integerAndItsPositionForInvertedSorting = new HashMap<Integer, Integer>();
		int[] sortedArr = new int[arr.length];
		int[] arrForInvertedSort = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			integerAndItsPosition.put(arr[i], i);
			integerAndItsPositionForInvertedSorting.put(arr[i], i);
			sortedArr[i] = arr[i];
			arrForInvertedSort[i] = arr[i];
		}
		Arrays.sort(sortedArr);
		
		// sorting in the incremental way
		int swaps = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==sortedArr[i])
				continue;
			int positionToBeSwapped = integerAndItsPosition.get(sortedArr[i]);
			int firstNumber = arr[i];
			arr[i] = arr[positionToBeSwapped];
			arr[positionToBeSwapped] = firstNumber;
			integerAndItsPosition.put(arr[i], i);
			integerAndItsPosition.put(arr[positionToBeSwapped], positionToBeSwapped);
			swaps++;
		}
		
		// sorting in the decremental way
		int swaps1 = 0;
		for(int i=arr.length-1;i>=0;i--)
		{
			if(arrForInvertedSort[i]==sortedArr[sortedArr.length-1-i])
				continue;
			int positionToBeSwapped = integerAndItsPositionForInvertedSorting.get(sortedArr[sortedArr.length-1-i]);
			int firstNumber = arrForInvertedSort[i];
			arrForInvertedSort[i] = arrForInvertedSort[positionToBeSwapped];
			arrForInvertedSort[positionToBeSwapped] = firstNumber;
			integerAndItsPositionForInvertedSorting.put(arrForInvertedSort[i], i);
			integerAndItsPositionForInvertedSorting.put(arrForInvertedSort[positionToBeSwapped], positionToBeSwapped);
			swaps1++;
		}
		if(swaps<swaps1)
			return swaps;
		else return swaps1;
    }
}
