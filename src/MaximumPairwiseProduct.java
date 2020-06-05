import java.util.*;
import java.io.*;

public class MaximumPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        int firstBiggestNumberIndex = -1;
        int secondBiggestNumberIndex = -1;
        
        for(int i=0;i<numbers.length;i++)
        {
        	if(firstBiggestNumberIndex == -1 || numbers[i] > numbers[firstBiggestNumberIndex])
        		firstBiggestNumberIndex = i;
        }
        
        for(int i=0;i<numbers.length;i++)
        {
        	if(i!=firstBiggestNumberIndex && (secondBiggestNumberIndex == -1 || numbers[i] > numbers[secondBiggestNumberIndex]))
        		secondBiggestNumberIndex = i;
        }
        max_product = (long)numbers[firstBiggestNumberIndex]* (long)numbers[secondBiggestNumberIndex];
        
        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}