package practice.algorithms.sorting;

import java.util.Scanner;

public class FraudulentActivityNotifications {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int d = scr.nextInt();
		int[] expenditure = new int[n];
		
		for(int i=0;i<n;i++)
			expenditure[i] = scr.nextInt();
		
		System.out.println(activityNotifications(expenditure, d));
	}
	
	static int activityNotifications(int[] expenditure, int d) {
		int[] trackingOfExpenditures = new int[201];
		for(int i=0;i<d;i++)
			trackingOfExpenditures[expenditure[i]]++;
		
		int sendNotification = 0;
		int removeFromTrackingOfExpenditure = -1;
		for(int i=d;i<expenditure.length;i++)
		{
			if(removeFromTrackingOfExpenditure!=-1)
			{
				trackingOfExpenditures[expenditure[removeFromTrackingOfExpenditure]]--;
				removeFromTrackingOfExpenditure++;
				trackingOfExpenditures[expenditure[i-1]]++;
			}
			else
				removeFromTrackingOfExpenditure++;
			
			if(d%2==0)
			{
				int medianNumber1 = d/2;
				int medianNumber2 = d/2 +1;
				int count=0;
				int median=0;
				boolean firstNumberConsidered = false;
				for(int j=0;j<201;j++)
				{
					count +=trackingOfExpenditures[j];
					if(medianNumber1<=count && !firstNumberConsidered)
					{
						firstNumberConsidered = true;
						median +=j;
					}
					if(medianNumber2<=count)
					{
						median+=j;
						break;		
					}
				}
				
				if(expenditure[i]>=median)
					sendNotification++;
			}
			else
			{
				int medianNumber = d/2+1;
				int count=0;
				int median=0;
				for(int j=0;j<201;j++)
				{
					count+=trackingOfExpenditures[j];
					if(medianNumber<=count)
					{
						median = j;
						break;
					}
				}
				if(expenditure[i]>=median*2)
					sendNotification++;
			}
			
			
		}
		
		
		return sendNotification;
    }
}
