/*
 *  Kadane's algorithm is a common algorithm
 *  used to find the sub contiguous array with 
 *  the maximum sum. In simple terms, the sub array
 *  with the maximum sum. 
 *  
 *  The idea behind this algorithm is to look for all 
 *  positive contiguous segments of the array (max_ending_here is used for this)
 * 
 *  We also keep track of the maximum sum of a contiguous segment among all positive
 *  segment (max_so_far is used for this)
 *  
 *  DISCLAIMER: this doesn't work if a list contains all negative values, for this follow
 *  this link for a full tutorial https://youtu.be/OexQs_cYgAQ?t=723
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
	
	// you can write your own test case here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,-2,-4, 5, 6, 7};
		
		System.out.println(Kadane_Algorithm.maxSubArraySum(input));
	}

}
