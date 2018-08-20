/*
 *  Kadane's algorithm is a common algorithm
 *  used to find the sub contiguous array with 
 *  the maximum sum. In simple terms, the sub array
 *  with the maximum sum. 
 * 
 * */
public class Kadane_Algorithm {

	public static int maxSubArraySum(int[]A){
		
		int max_ending_here = 0;
		int max_so_far = 0;
		
		for(int i=0; i<A.length; i++){
			
			max_ending_here = max_ending_here + A[i];
			
			// negative sums will never make the largest sum so reset variable
			if(max_ending_here < 0){
				max_ending_here = 0;
			}
			else if(max_ending_here > max_so_far){
				max_so_far = max_ending_here; 
			}
		}
		
		return max_so_far;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,-2,-4, 5, 6, 7};
		
		System.out.println(Kadane_Algorithm.maxSubArraySum(input));
	}

}
