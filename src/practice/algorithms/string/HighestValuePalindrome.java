package practice.algorithms.string;

import java.io.File;
import java.io.FileOutputStream;
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
		char[] sCharacters = s.toCharArray();
		for(int i=sCharacters.length%2==0?sCharacters.length/2-1:sCharacters.length/2;i>=0;i--)
		{
			if(k>=n)
			{
				if(i==sCharacters.length-1-i)
				{
					if(sCharacters[i]!='9')
					{
						sCharacters[i]='9';
						k--;
					}
					n--;
				}
				else
				{
					if(sCharacters[i]!='9' || sCharacters[sCharacters.length-1-i]!='9')
					{
						if(sCharacters[i]!=9)
						{
							sCharacters[i]='9';
							k--;
						}
						if(sCharacters[sCharacters.length-1-i]!='9')
						{
							sCharacters[sCharacters.length-1-i]='9';
							k--;
						}
					}
					n-=2;
				}
			}
			else
			{
				if(i!=sCharacters.length-1-i)
				{
					if(sCharacters[i]!=sCharacters[sCharacters.length-1-i])
					{
						if(k<1)
							return String.valueOf(-1);
						char greaterCharacter = sCharacters[i]>sCharacters[sCharacters.length-1-i]?sCharacters[i]:sCharacters[sCharacters.length-1-i];
						sCharacters[i]=greaterCharacter;
						sCharacters[sCharacters.length-1-i]=greaterCharacter;
						k--;
					}
					n-=2;
				}
				else n--;
			}
		}
		if(k>0)
			for(int i=0;i<=(sCharacters.length%2==0?sCharacters.length/2-1:sCharacters.length/2);i++)
			{
				if(k<1)
					break;
				if(i!=sCharacters.length-1-i)
				{
					if(sCharacters[i]!='9' && k>1)
					{
						sCharacters[i]='9';
						sCharacters[sCharacters.length-i-1]='9';
						k-=2;
					}
				}
				else
				{
					if(sCharacters[i]!='9')
					{
						sCharacters[i]='9';
						k--;
					}
				}
			}
		
		File file = new File("temp.txt");
		if(!file.exists())
			file.createNewFile();
		
		FileOutputStream inputStream = new FileOutputStream(file);
		inputStream.write(String.valueOf(sCharacters).getBytes());
		inputStream.flush();
		inputStream.close();
		return String.valueOf(sCharacters);
	}
}
