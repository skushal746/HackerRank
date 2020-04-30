package practice.algorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCase = scr.nextInt();
		String enter = scr.nextLine();
		for(int i=0;i<testCase;i++)
		{
			String s = scr.nextLine();
			System.out.println(sherlockAndAnagrams(s));
		}
	}
	
	static int sherlockAndAnagrams(String s) {
		Map<String,Map<Character,Integer>> trackingOfCharacters = new HashMap<String, Map<Character, Integer>>();
		char[] sCharacters = s.toCharArray();
		int amountOfAnagrams = 0;
		for(int i=0;i<sCharacters.length-1;i++)
		{
			for(int j=0;i+j<sCharacters.length;j++)
			{
				Map<Character, Integer> characters = new HashMap<Character, Integer>();
				if(i==0)
				{
					characters.put(sCharacters[j], 1);
				}
				else
				{
					for(Map.Entry<Character, Integer> entry : trackingOfCharacters.get(String.valueOf(j) + String.valueOf(i+j-1)).entrySet())
					{
						if(entry.getKey() == sCharacters[i+j])
						{
							characters.put(entry.getKey(), entry.getValue() + 1);
						}
						else
						{
							characters.put(entry.getKey(), entry.getValue());
						}
					}
					
					if(!trackingOfCharacters.get(String.valueOf(j) + String.valueOf(i+j-1)).containsKey(sCharacters[i+j]))
						characters.put(sCharacters[i+j], 1);
				}
				trackingOfCharacters.put(String.valueOf(j) + String.valueOf(i+j), characters);
			}
			
			for(int j=0;i+j<sCharacters.length-1;j++)
			{
				Map<Character, Integer> currentMapTOBeChecked = trackingOfCharacters.get(String.valueOf(j) + String.valueOf(i+j));
				int start = j+1;
				int end = i+j+1;
				while(end < sCharacters.length)
				{
					boolean isAnagram = true;
					for(Map.Entry<Character, Integer> entry : currentMapTOBeChecked.entrySet())
					{
						if(trackingOfCharacters.get(String.valueOf(start) + String.valueOf(end)).get(entry.getKey())!=entry.getValue())
						{
							isAnagram = false;
							break;
						}
					}
					if(isAnagram)
						amountOfAnagrams++;
					start++;
					end++;
				}
			}
		}
		return amountOfAnagrams;
    }
	
}
