package practice.algorithms.implementation;

import java.util.Scanner;

public class TheBombermanGame {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int rows = scr.nextInt();
		int columns = scr.nextInt();
		int n = scr.nextInt();
		String enter = scr.nextLine();
		String[] grid = new String[rows];
		for(int i=0;i<rows;i++)
			grid[i] = scr.nextLine();
		grid = bomberMan(n, grid);
		for(int i=0;i<grid.length;i++)
			System.out.println(grid[i]);
		scr.close();
	}
	
	// Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
    	int rows = grid.length;
    	int columns = grid[0].length();
    	char[][] gridCharcaters = new char[grid.length][grid[0].length()];
    	char[][] transformedGridCharacter = new char[rows][columns];
    	for(int i=0;i<grid.length;i++)
    		gridCharcaters[i] = grid[i].toCharArray();
    	if( n%4==1)
    		return grid;
    	if(n%2==0)
    	{
    		for(int i=0;i<rows;i++)
    			for(int j=0;j<columns;j++)
    				gridCharcaters[i][j]='O';
    		for(int i=0;i<rows;i++)
    			grid[i] = String.valueOf(gridCharcaters[i]);
    		return grid;
    	}
    	else
    	{
    		for(int i=0;i<rows;i++)
    			for(int j=0;j<columns;j++)
    			{
    				boolean isItselfOrNeighbourHavingBomb = false;
    				
    				if(gridCharcaters[i][j]=='O')
    					isItselfOrNeighbourHavingBomb = true;
    				
    				if(i==0 && rows>1)
    				{
    					if(gridCharcaters[i+1][j]=='O')
    						isItselfOrNeighbourHavingBomb = true;
    				}
    				else if(i==rows-1 && rows>1)
    				{	
    					if(gridCharcaters[i-1][j]=='O')
    						isItselfOrNeighbourHavingBomb = true;
    				}
    				else if(gridCharcaters[i+1][j]=='O' || gridCharcaters[i-1][j]=='O')
    					isItselfOrNeighbourHavingBomb = true;
    				
    				if(j==0 && columns>1)
    				{
    					if(gridCharcaters[i][j+1]=='O')
    						isItselfOrNeighbourHavingBomb = true;
    				}
    				else if(j==columns-1 && columns>1)
    				{	
    					if(gridCharcaters[i][j-1]=='O')
    						isItselfOrNeighbourHavingBomb = true;
    				}
    				else if(gridCharcaters[i][j+1]=='O' || gridCharcaters[i][j-1]=='O')
    					isItselfOrNeighbourHavingBomb = true;
    				
    				if(isItselfOrNeighbourHavingBomb)
    					transformedGridCharacter[i][j]='.';
    				else transformedGridCharacter[i][j]='O';
    				
    			}
    		
    		for(int i=0;i<rows;i++)
    			grid[i] = String.valueOf(transformedGridCharacter[i]);
    		
    		return grid;
    	}
    }
}
