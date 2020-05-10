package practice.algorithms.implementation;

import java.util.Scanner;

public class CavityMap {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		
		String enter = scr.nextLine();
		String[] grid = new String[n];
		for(int i=0;i<n;i++)
			grid[i] = scr.nextLine();
		grid = cavityMap(grid);
		for(int i=0;i<grid.length;i++)
			System.out.println(grid[i]);
		scr.close();
	}
	
	static String[] cavityMap(String[] grid) {
		
		char[][] cavityMapAnotherForm = new char[grid.length][grid.length];
		for(int i=0;i<grid.length;i++)
		{
			cavityMapAnotherForm[i] = grid[i].toCharArray();
		}
		for(int i=1;i<grid.length-1;i++)
		{
			for(int j=1;j<grid.length-1;j++)
			{
				if(Character.valueOf(cavityMapAnotherForm[i][j]) > Character.valueOf(cavityMapAnotherForm[i+1][j])
						&& Character.valueOf(cavityMapAnotherForm[i][j]) > Character.valueOf(cavityMapAnotherForm[i-1][j])
						&& Character.valueOf(cavityMapAnotherForm[i][j]) > Character.valueOf(cavityMapAnotherForm[i][j+1])
						&& Character.valueOf(cavityMapAnotherForm[i][j]) > Character.valueOf(cavityMapAnotherForm[i][j-1]))
					cavityMapAnotherForm[i][j]='X';
			}
			grid[i] = String.valueOf(cavityMapAnotherForm[i]);
		}
		return grid;
    }
}
