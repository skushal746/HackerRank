package practice.algorithms.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommonChild {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String s1 = scr.nextLine();
		String s2 = scr.nextLine();
		System.out.println(commonChild(s1, s2));
	}
	
	static int commonChild(String s1, String s2) {
		Map<String, ArrayList<Integer>> commonChildTracker = new HashMap<String, ArrayList<Integer>>();
		for(int i=0;i<s1.length();i++)
		{
			if(commonChildTracker.size()==0)
			{
				
			}
			else
			{
				
			}
		}
		return 0;
    }
	
}
