package practice.algorithms.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumLoss {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		long[] price = new long[n];
		for(int i=0;i<n;i++)
			price[i]=scr.nextLong();
		System.out.println(minimumLoss(price));
	}
	
	static int minimumLoss(long[] price) {
		long minimumLossValue=2147483647;
		long[] sortedPrice = new long[price.length];
		Map<Long,Integer> priceAndItsIndex = new HashMap<Long, Integer>();
		for(int i=0;i<price.length;i++)
		{
			sortedPrice[i]=price[i];
			priceAndItsIndex.put(price[i], i);
		}
		Arrays.sort(sortedPrice);
		
		for(int i=sortedPrice.length-1;i>0;i--)
		{
			int tracker = i-1;
			while(true)
			{
				if(tracker==-1)
					break;
				if(priceAndItsIndex.get(sortedPrice[i])<priceAndItsIndex.get(sortedPrice[tracker]))
				{
					if(minimumLossValue >(sortedPrice[i]-sortedPrice[tracker]))
						minimumLossValue = sortedPrice[i]-sortedPrice[tracker];
					break;
				}
				else if(sortedPrice[i]-sortedPrice[tracker] > minimumLossValue)
					break;
				else
					tracker--;
			}
		}
		return (int) minimumLossValue;
    }
	
}
