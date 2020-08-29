package practice.algorithms.string;

import java.util.Scanner;

public class TwoStrings {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testcase = scr.nextInt();
		
		String useless = scr.nextLine();
		for(int i=0;i<testcase;i++)
		{
			String s1 = scr.nextLine();
			String s2 = scr.nextLine();
			
			System.out.println(twoStrings(s1, s2));
		}
		
	}
	
	static String twoStrings(String s1, String s2) {
		int[] tracker1 = new int[225];
		int[] tracker2 = new int[225];
		char[] s1Characters = s1.toCharArray();
		char[] s2Characters = s2.toCharArray();

		for(int i=0;i<s1Characters.length;i++)
			tracker1[s1Characters[i]]++;
		for(int i=0;i<s2Characters.length;i++)
			tracker2[s2Characters[i]]++;
		
		boolean commonSubString = false;
		for(int i=0;i<225;i++)
		{
			if(tracker1[i]>0 && tracker2[i]>0)
				commonSubString=true;
		}
		
		
		if(commonSubString)
			return "YES";
		else return "NO";
    }
}
