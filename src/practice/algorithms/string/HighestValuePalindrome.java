package practice.algorithms.string;

import java.io.IOException;
import java.util.Scanner;

public class HighestValuePalindrome {
	public static void main(String[] args) throws IOException {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		String enter = scr.nextLine();
		String s = scr.nextLine();
		System.out.println(highestValuePalindrome(s, n, k));
		scr.close();
	}
	
	static String highestValuePalindrome(String s, int n, int k) throws IOException {
		char[] stringCharacters = s.toCharArray();
		int minimumChangesRequired = 0;
		for(int i=0;i<n/2;i++)
			if(stringCharacters[i]!=stringCharacters[n-1-i])
				minimumChangesRequired++;
		if(k < minimumChangesRequired)
			return String.valueOf(-1);
		
		for(int i=0;i<n/2;i++)
		{
			if(stringCharacters[i]==stringCharacters[n-1-i] && stringCharacters[i]!='9' && (k>=minimumChangesRequired+2))
			{
				k-=2;
				stringCharacters[i] = '9';
				stringCharacters[n-1-i] = '9';
			}
			else if(stringCharacters[i]!=stringCharacters[n-1-i])
			{
				if(stringCharacters[i]=='9' || stringCharacters[n-1-i]=='9')
				{
					stringCharacters[i]='9';
					stringCharacters[n-1-i]='9';
					minimumChangesRequired--;
					k--;
				}
				else if(k==minimumChangesRequired)
				{
					char greaterCharacter = stringCharacters[i]>stringCharacters[n-1-i]?stringCharacters[i]:stringCharacters[n-1-i];
					stringCharacters[i] = greaterCharacter;
					stringCharacters[n-1-i] = greaterCharacter;
					minimumChangesRequired--;
					k--;	
				}
				else if(k>=minimumChangesRequired+1)
				{
					stringCharacters[i]='9';
					stringCharacters[n-1-i]='9';
					minimumChangesRequired--;
					k-=2;	
				}
				
			}
		}
		
		if(n%2==1 && stringCharacters[n/2]!='9' && k>0)
			stringCharacters[n/2]='9';
		
		return String.valueOf(stringCharacters);
	}
}
