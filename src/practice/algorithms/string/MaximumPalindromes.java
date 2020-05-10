package practice.algorithms.string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MaximumPalindromes {	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String s = scr.nextLine();
		Result.initialize(s);
		int q = scr.nextInt();
		for(int i=0;i<q;i++)
		{
			System.out.println(Result.answerQuery(scr.nextInt(), scr.nextInt()));
		}
	}
}

class Result {

    /*
     * Complete the 'initialize' function below.
     *
     * The function accepts STRING s as parameter.
     */
	static Map<String, Map<Character, Integer>> characterTracking = new HashMap<String, Map<Character, Integer>>();
 
    public static void initialize(String s) {
    // This function is called once before all queries.
    	char[] sCharacters = s.toCharArray();
    	for(int i=0;i<s.length();i++)
    	{
    		for(int j=0;i+j<s.length();j++)
    		{
    			Map<Character,Integer> currentIterationCharacterTracking = new HashMap<Character, Integer>();
    			if(i==0)
    			{
    				currentIterationCharacterTracking.put(sCharacters[j],1);
    			}
    			else
    			{
    				for(Map.Entry<Character, Integer> entry : characterTracking.get(String.valueOf(j) + "," + String.valueOf(i+j-1)).entrySet())
    				{
    					if(entry.getKey() == sCharacters[j+i])
    					{
    						currentIterationCharacterTracking.put(entry.getKey(), entry.getValue() +1);	
    					}
    					else
    					{
    						currentIterationCharacterTracking.put(entry.getKey(), entry.getValue());
    					}
    				}
    				if(!characterTracking.get(String.valueOf(j) + "," +  String.valueOf(i+j-1)).containsKey(sCharacters[j+i]))
    				{
    					currentIterationCharacterTracking.put(sCharacters[j+i],1);
    				}
    			}
    			characterTracking.put(String.valueOf(j) + "," + String.valueOf(i+j), currentIterationCharacterTracking);
    		}
    	}	
    }

    /*
     * Complete the 'answerQuery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int answerQuery(int l, int r) {
    // Return the answer for this query modulo 1000000007.
    	
    	Map<Character, Integer> charactersCounting = characterTracking.get(String.valueOf(l-1) + "," + String.valueOf(r-1));
    	long result=1;
    	int currentCount = 1;
    	for(Map.Entry<Character, Integer> entry : charactersCounting.entrySet())
    	{
    		int count = entry.getValue()/2;
    		if(count!=0)
    		{
	    		for(int i = currentCount; i < count + currentCount ; i++)
	    		{
	    			result = result*i;
	    		}
    			result = result/(count);
    			currentCount = currentCount + count;
    		}
    		result=result%1000000007;
    	}
    	int singleCharacterThatCanBeAdded = 0;
    	for(Map.Entry<Character, Integer> entry : charactersCounting.entrySet())
    	{
    		if(entry.getValue()%2!=0)
    			singleCharacterThatCanBeAdded++;
    	}
    	if(singleCharacterThatCanBeAdded!=0)
    		result = result*singleCharacterThatCanBeAdded;
    	result = result%1000000007;
    	return (int)result;
    }

}