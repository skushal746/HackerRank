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
		int numberRequired = gene.length()/4;
		char[] geneCharacters = gene.toCharArray();
		Map<Character, Integer> currentlyContains = new HashMap<Character, Integer>();
		Map<Character, Integer> needsToBeChanged = new HashMap<Character, Integer>();
		currentlyContains.put('A', 0);
		currentlyContains.put('C', 0);
		currentlyContains.put('G', 0);
		currentlyContains.put('T', 0);
		needsToBeChanged.put('A', 0);
		needsToBeChanged.put('C', 0);
		needsToBeChanged.put('G', 0);
		needsToBeChanged.put('T', 0);
		List<Character> charNeedsChanging = new ArrayList<Character>();
		for(int i=0;i<geneCharacters.length;i++)
		{
			currentlyContains.put(geneCharacters[i], currentlyContains.get(geneCharacters[i])+1);
		}
		for(Map.Entry<Character, Integer> entry : currentlyContains.entrySet())
			if(entry.getValue() > numberRequired)
			{
				needsToBeChanged.put(entry.getKey(), entry.getValue()-numberRequired);
				charNeedsChanging.add(entry.getKey());
			}
		
		int lengthOfSubStringNeedToBeChanged = 500000;
		
		for(int i=0;i<geneCharacters.length;i++)
		{
			if(charNeedsChanging.contains(geneCharacters[i]))
			{
				Map<Character, Integer> subStringHoldingCharacters = new HashMap<Character, Integer>();
				int subStringLength = 0;
				subStringHoldingCharacters.put('A', 0);
				subStringHoldingCharacters.put('C', 0);
				subStringHoldingCharacters.put('G', 0);
				subStringHoldingCharacters.put('T', 0);
				boolean findSubString = true;
				while(subStringHoldingCharacters.get('A') <  needsToBeChanged.get('A')
						|| subStringHoldingCharacters.get('C') <  needsToBeChanged.get('C')
						|| subStringHoldingCharacters.get('G') <  needsToBeChanged.get('G')
						|| subStringHoldingCharacters.get('T') <  needsToBeChanged.get('T'))
				{
					if(i+subStringLength>=geneCharacters.length)
					{
						findSubString = false;
						break;
					}
					subStringHoldingCharacters.put(geneCharacters[i + subStringLength], subStringHoldingCharacters.get(geneCharacters[i + subStringLength]) + 1);
					subStringLength++;
				}
				
				if(lengthOfSubStringNeedToBeChanged > subStringLength && findSubString)
					lengthOfSubStringNeedToBeChanged = subStringLength;
			}
		}
		
		
		return lengthOfSubStringNeedToBeChanged;
    }	
}
