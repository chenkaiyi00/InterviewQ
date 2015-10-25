import java.util.HashMap;
import java.util.Map;

public class Twosum {
 // using hash table extra O(n) space;
	
	public int[] indices(int[] nums, int target) {
		int answers[] = new int[2];
		Map<Integer, Integer> table = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (table.containsKey(target - nums[i])) {
				answers[0] = table.get(target - nums[i]);
				answers[1] = i;
				return answers;
			} else {
				table.put(nums[i], i);
			}
		}

		return null;
	}
	public int bsearch(int[] nums,int target){
		int left =0;
		int right = nums.length-1;
		while(left<=right){
			int medium = left+(right-left)/2;
			if(nums[medium]==target)return medium;
			else if(nums[medium]<target){
				left=medium+1;
			}else{
				right=medium-1;
			}
		}
		return -1; // when not found
		
	}
	
	public int[] twopinters(int[]nums,int target){
		int left=0;
		int right=nums.length-1;
		while(left<=right){
			int a = nums[left];
			int b = nums[right];
			if((a+b)==target){
				return new int[]{left,right};
			}else if ((a+b)<target){
				left++;
			}else {
				right--;
			}
			
		}
		return null;
		
	}
	public static void main(String args[]){
		int nums[] ={1,2,3,5,6};
		Twosum t = new Twosum();
		int[] an=t.indices(nums,4);
		int a = t.bsearch(nums, 2);
		int[] twopointer=t.twopinters(nums, 4);
		System.out.println("twopointer[0]= "+twopointer[0]);
		System.out.println("twopointer[1]= "+twopointer[1]);
		System.out.println(" "+an[0]);
		System.out.println(" "+an[1]);
		
		
		
	}
}
