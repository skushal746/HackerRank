package practice.algorithms.implementation;

import java.util.Scanner;

public class HappyLadybugs {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int testCase = scr.nextInt();
		for(int i=0;i<testCase;i++)
		{
			int lengthOfInput = scr.nextInt();
			String useless = scr.nextLine();
			String b = scr.nextLine();
			System.out.println(b);
			System.out.println(happyLadybugs(b));
		}
		
	}
	
	static String happyLadybugs(String b) {

        char[] bCharacters = b.toCharArray();
        int[] charactersCount = new int[200];
        boolean isSpaceAvailable = false;
        boolean everyBugAlreadyHappy = true;
        for(int i=0;i<b.length();i++)
        {
            if(bCharacters[i]=='_')
                isSpaceAvailable = true;
            else charactersCount[bCharacters[i]]++;

            if(!((i+1<b.length() && bCharacters[i+1]==bCharacters[i])|| (i-1>-1 && bCharacters[i-1]==bCharacters[i])))
                everyBugAlreadyHappy = false;
        }


        boolean everyBugHappy = true;
        if(isSpaceAvailable)
            for(int i=0;i<charactersCount.length;i++)
            {
                if(charactersCount[i]==1)
                    everyBugHappy = false;
            }
        else 
        {
            if(!everyBugAlreadyHappy)
                everyBugHappy = false;
        }


        if(everyBugHappy)
            return "YES";
        else return "NO";

    }
}
