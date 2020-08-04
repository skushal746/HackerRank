package practice.algorithms.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		String enter = scr.nextLine();
		System.out.println(enter);
		String gene = scr.nextLine();
		System.out.println(steadyGene(gene));
		scr.close();
	}
	
	static int steadyGene(String gene) {
		
		int required = gene.length()/4;
		char[] geneCharacters = gene.toCharArray();
		int gCharacters = 0;
		int cCharacters = 0;
		int aCharacters = 0;
		int tCharacters = 0;
		
		for(int i=0;i<gene.length();i++)
		{
			if(geneCharacters[i]=='G')
				gCharacters++;
			else if(geneCharacters[i]=='C')
				cCharacters++;
			else if(geneCharacters[i]=='T')
				tCharacters++;
			else aCharacters++;
		}
		
		Map<Character, Integer> toBeRemoved = new HashMap<Character, Integer>();
		if(gCharacters>required)
			toBeRemoved.put('G', gCharacters-required);
		if(cCharacters>required)
			toBeRemoved.put('C', cCharacters-required);
		if(tCharacters>required)
			toBeRemoved.put('T', tCharacters-required);
		if(aCharacters>required)
			toBeRemoved.put('A', aCharacters-required);
		
		int gRequired = toBeRemoved.containsKey('G')?toBeRemoved.get('G'):0;
		int cRequired = toBeRemoved.containsKey('C')?toBeRemoved.get('C'):0;
		int tRequired = toBeRemoved.containsKey('T')?toBeRemoved.get('T'):0;
		int aRequired = toBeRemoved.containsKey('A')?toBeRemoved.get('A'):0;
		
		/*
		for(Map.Entry<Character, Integer> singleEntry : toBeRemoved.entrySet())
			System.out.println(singleEntry.getKey() + " " + singleEntry.getValue());
		*/
		
		int minimumLength = -1;
		for(int i=0;i<geneCharacters.length;i++)
		{
			int gReceived = 0;
			int cReceived = 0;
			int tReceived = 0;
			int aReceived = 0;
			if(toBeRemoved.containsKey(geneCharacters[i]))
			{
				int j = i;
				
				boolean validCase = true;
				
				while(!(gReceived>=gRequired && cReceived>=cRequired && tReceived>=tRequired && aReceived>=aRequired))
				{
					if(j==gene.length())
					{
						validCase=false;
						break;
					}
					
					if(geneCharacters[j]=='G')
						gReceived++;
					else if(geneCharacters[j]=='C')
						cReceived++;
					else if(geneCharacters[j]=='T')
						tReceived++;
					else aReceived++;
					
					j++;
				}
				if(validCase)
					if(minimumLength ==-1 || minimumLength>(j-i))
						minimumLength = j-i;
			}
		}
		return minimumLength;
    }	
}
