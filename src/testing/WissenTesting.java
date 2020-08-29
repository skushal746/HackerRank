package testing;

import java.io.*;
import java.util.*;

public class WissenTesting {


	static int minParkingSpaces(int[][] parkingStartEndTimes) {
          // YOUR CODE HERE
		
		List<ArrayList<Integer>> parkingTimeTracking = new ArrayList<ArrayList<Integer>>();
		int maxParkingNeeded = 0;
		
		for(int i=0;i<parkingStartEndTimes.length;i++)
		{
			if(parkingTimeTracking.size()==0)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(parkingStartEndTimes[i][0]);
				temp.add(parkingStartEndTimes[i][1]);
				temp.add(1);
				parkingTimeTracking.add(temp);
			}
			else if(parkingTimeTracking.get(0).get(0)>parkingStartEndTimes[i][0])
			{
				int tracking=0;
				int start = parkingStartEndTimes[i][0];
				int end = parkingStartEndTimes[i][1];
				
				if(parkingTimeTracking.get(0).get(0)<end)
				{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(start);
					temp.add(end);
					temp.add(1);
					parkingTimeTracking.add(0,temp);
				}
				else
				{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(start);
					temp.add(parkingTimeTracking.get(0).get(0)-1);
					temp.add(1);
					parkingTimeTracking.add(0,temp);
					start = parkingTimeTracking.get(0).get(0);
					tracking++;
					while(true)
					{
						if(parkingTimeTracking.get(tracking).get(1)==end)
						{
							parkingTimeTracking.get(tracking).add(2, parkingTimeTracking.get(tracking).get(2)+1);
							break;
						}
						else if(parkingTimeTracking.get(tracking).get(1)<end)
						{
							parkingTimeTracking.get(tracking).add(2, parkingTimeTracking.get(tracking).get(2)+1);
							tracking++;
						}
						else
						{
							
						}
					}
				}
				
			}
			else if(parkingTimeTracking.get(parkingTimeTracking.size()-1).get(0)>parkingStartEndTimes[i][0])
			{
				
			}
			else
			{
				int start=0;
				int end = parkingTimeTracking.size();
				while(start<=end)
				{
					int mid = (start + end)/2;
					if(parkingTimeTracking.get(mid).get(0)<=parkingStartEndTimes[i][0] && parkingTimeTracking.get(mid).get(1)<=parkingStartEndTimes[i][0])
					{
						
					}
					else if((mid+1<parkingTimeTracking.size()-1) && parkingTimeTracking.get(mid).get(1)<=parkingStartEndTimes[i][0] && parkingTimeTracking.get(mid+1).get(0)>=parkingStartEndTimes[i][0])
					{
						
					}
					else if(parkingTimeTracking.get(mid).get(0)<=parkingStartEndTimes[i][0])
						start = mid+1;
					else end = mid-1;
				}
			}
		}
		
		

		return 0;

		
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}
