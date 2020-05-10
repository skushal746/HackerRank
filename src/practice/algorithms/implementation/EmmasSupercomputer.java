package practice.algorithms.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmmasSupercomputer {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int m = scr.nextInt();
		String[] grid = new String[n];
		String enter = scr.nextLine();
		for(int i=0;i<n;i++)
			grid[i] = scr.nextLine();
		System.out.println(twoPluses(grid));
		
		scr.close();
	}
	
	static int twoPluses(String[] grid) {
		
		int n = grid.length;
		int m = grid[0].length();
		
		Map<Integer, HashMap<Integer,List<Integer>>> validPlusTracking = new HashMap<Integer, HashMap<Integer, List<Integer>>>();
		
		List<Integer> allAreas = new ArrayList<Integer>();
		for(int i=1;i<=15;i++)
			allAreas.add((i*2-1)*2-1);
		
		int[][] topGoodCells = new int[n][m];
		int[][] bottomGoodCells = new int[n][m];
		int[][] leftGoodCells = new int[n][m];
		int[][] rightGoodCells = new int[n][m];
		char[][] gridCharacters = new char[n][m];
		for(int i=0;i<grid.length;i++)
			gridCharacters[i] = grid[i].toCharArray();
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(i==0 && gridCharacters[i][j]=='G')
					topGoodCells[i][j]=1;
				else if(i!=0 && gridCharacters[i][j]=='G')
					topGoodCells[i][j] = 1 + topGoodCells[i-1][j];
				
				if (j==0 && gridCharacters[i][j]=='G')
					leftGoodCells[i][j]=1;
				else if(j!=0 && gridCharacters[i][j]=='G')
					leftGoodCells[i][j] = 1 + leftGoodCells[i][j-1];
			}
		}
		
		for(int i=n-1;i>=0;i--)
			for(int j=m-1;j>=0;j--)
			{
				if(i==n-1 && gridCharacters[i][j]=='G')
					bottomGoodCells[i][j]=1;
				else if(i!=n-1 && gridCharacters[i][j]=='G')
					bottomGoodCells[i][j] = 1 + bottomGoodCells[i+1][j];
				
				if (j==m-1 && gridCharacters[i][j]=='G')
					rightGoodCells[i][j]=1;
				else if (j!=m-1 && gridCharacters[i][j]=='G')
					rightGoodCells[i][j] = 1 + rightGoodCells[i][j+1];
			}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				int lowestNumber = topGoodCells[i][j]>bottomGoodCells[i][j]?bottomGoodCells[i][j]:topGoodCells[i][j];
				if(lowestNumber > leftGoodCells[i][j])
					lowestNumber = leftGoodCells[i][j];
				if(lowestNumber > rightGoodCells[i][j])
					lowestNumber = rightGoodCells[i][j];
				
				if(lowestNumber > 0)
					for(int k=lowestNumber ; k>0 ; k--)
					{
						int currentArea = (k*2-1)*2-1;
						HashMap<Integer, List<Integer>> coordinatesForCurrentArea = validPlusTracking.get(currentArea);
						if(coordinatesForCurrentArea==null)
						{
							HashMap<Integer, List<Integer>> coordinates = new HashMap<Integer,List<Integer>>();
							List<Integer> yCoordinates = new ArrayList<Integer>();
							yCoordinates.add(j);
							coordinates.put(i, yCoordinates);
							validPlusTracking.put(currentArea,coordinates);
						}
						else
						{
							List<Integer> yCoordinates = coordinatesForCurrentArea.get(i);
							if(yCoordinates == null)
							{
								List<Integer> tempYCooridinates = new ArrayList<Integer>();
								tempYCooridinates.add(j);
								coordinatesForCurrentArea.put(i, tempYCooridinates);
							}
							else if(!yCoordinates.contains(j))
							{
								yCoordinates.add(j);
							}
						}
					}
			}
		
		/*
		for(Map.Entry<Integer, HashMap<Integer,List<Integer>>> testEntry : validPlusTracking.entrySet())
		{
			System.out.println(" Area : " + testEntry.getKey());
			HashMap<Integer, List<Integer>> correspondingCoordinates = testEntry.getValue();
			for(Map.Entry<Integer, List<Integer>> singleLevelCorodinates : correspondingCoordinates.entrySet())
			{
				System.out.println("X Coordinates : " + singleLevelCorodinates.getKey());
				System.out.print("Y Coordinates : ");
				for(Integer singleYCoordinate : singleLevelCorodinates.getValue())
					System.out.print(singleYCoordinate + " ");
				System.out.println();
			}
		}
		*/
		
		/*
		 * Overlapping logic
		 */
		int maximumMultiplication = 0;
		
		for(Integer firstNumber : allAreas)
		{
			for(Integer secondNumber : allAreas)
			{
				if(!validPlusTracking.containsKey(firstNumber) || !validPlusTracking.containsKey(secondNumber))
					continue;
				if(secondNumber > firstNumber)
					continue;
				
				int awayFromCoordinateOfFirstNumber = ((firstNumber+1)/2+1)/2;
				int awayFromCoordinateOfSecondNumber = ((secondNumber+1)/2+1)/2;
				int smallerDistanceOutOfTheTwo = awayFromCoordinateOfFirstNumber<awayFromCoordinateOfSecondNumber?awayFromCoordinateOfFirstNumber:awayFromCoordinateOfSecondNumber;
				int biggerDistanceOutOfTheTwo = awayFromCoordinateOfFirstNumber>awayFromCoordinateOfSecondNumber?awayFromCoordinateOfFirstNumber:awayFromCoordinateOfSecondNumber;
				
				Map<Integer, List<Integer>> firstMap = validPlusTracking.get(firstNumber);
				Map<Integer, List<Integer>> secondMap = validPlusTracking.get(secondNumber);
				
				for(Map.Entry<Integer, List<Integer>> firstEntry : firstMap.entrySet())
				{
					for(Map.Entry<Integer, List<Integer>> secondEntry : secondMap.entrySet())
					{
						int xCoordinate1 = firstEntry.getKey();
						List<Integer> yCoordinate1 = firstEntry.getValue();
						
						int xCoordinate2 = secondEntry.getKey();
						List<Integer> yCoordinate2 = secondEntry.getValue();
						
						for(Integer singleYCoordinate1 : yCoordinate1)
						{
							for(Integer singleYCoordinate2 : yCoordinate2)
							{
								if(singleYCoordinate1.intValue() == singleYCoordinate2.intValue() && xCoordinate1 == xCoordinate2)
									continue;
								
								if(xCoordinate1 == xCoordinate2)
								{
									if((Math.abs(singleYCoordinate1.intValue() - singleYCoordinate2.intValue()) -1) >= (awayFromCoordinateOfFirstNumber+awayFromCoordinateOfSecondNumber -2))
										if(firstNumber * secondNumber > maximumMultiplication)
											maximumMultiplication = firstNumber*secondNumber;
								}
								else if(singleYCoordinate1.intValue() == singleYCoordinate2.intValue())
								{
									if((Math.abs(xCoordinate1 - xCoordinate2) -1) >= (awayFromCoordinateOfFirstNumber + awayFromCoordinateOfSecondNumber -2))
										if(firstNumber * secondNumber > maximumMultiplication)
											maximumMultiplication = firstNumber*secondNumber;
								}
								else if(((Math.abs(xCoordinate1 - xCoordinate2) -1) >= (smallerDistanceOutOfTheTwo-1)
										&& (Math.abs(singleYCoordinate1.intValue() - singleYCoordinate2.intValue()) -1) >= (smallerDistanceOutOfTheTwo-1))
										|| ((Math.abs(xCoordinate1 - xCoordinate2) -1) >= (biggerDistanceOutOfTheTwo-1))
										|| ((Math.abs(singleYCoordinate1.intValue() - singleYCoordinate2.intValue()) -1) >= (biggerDistanceOutOfTheTwo-1)))
									if(firstNumber*secondNumber > maximumMultiplication)
										maximumMultiplication = firstNumber*secondNumber;
							}
						}
						
					}
				}
			}
		}
		return maximumMultiplication;
    }
}