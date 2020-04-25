package practice.algorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndTheValidStrings {
	
	public static void main(String[] args) {	
		Scanner scr = new Scanner(System.in);
		String s = scr.nextLine();
		System.out.println(isValid(s));
	}
	
	static String isValid(String s) {

		Map<Character, Integer> charactesrCount = new HashMap<Character, Integer>();
		char[] sCharacters = s.toCharArray();
		for(int i=0;i<sCharacters.length;i++)
		{
			if(charactesrCount.containsKey(sCharacters[i]))
			{
				charactesrCount.put(sCharacters[i], charactesrCount.get(sCharacters[i])+1);
			}
			else
			{
				charactesrCount.put(sCharacters[i], 1);
			}
		}
		
		int count1=0;
		int count2=0;
		int countOfCount1 = 0;
		int countOfCount2 = 0;
		boolean validString = true;
		for(Map.Entry<Character, Integer> singleEntry : charactesrCount.entrySet())
		{
			if(count1==0 && count2 ==0)
			{
				count1 = singleEntry.getValue();
				countOfCount1++;
			}
			else if (singleEntry.getValue()== count1)
				countOfCount1++;
			else if(singleEntry.getValue()!=count1 && count2==0)
			{
				count2 = singleEntry.getValue();
				countOfCount2++;
			}
			else if(singleEntry.getValue()==count2)
				countOfCount2++;
			else
			{
				validString = false;
				break;
			}
			
			
		}
		
		if(validString)
			if(count1!=0 && count2!=0)
			{
				if(countOfCount1==1 || countOfCount2 ==1)
				{
					if(!(count1==1 && countOfCount1==1) && !(count2==1 && countOfCount2==1))
						if(Math.abs(count1-count2)!=1)
							validString=false;
				}
				else 
					validString = false;
			}
		if(validString)
			return "YES";
		else return "NO";
    }
}
