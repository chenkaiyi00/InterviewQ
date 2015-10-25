//Could you do it in-place without allocating extra space?
//O(n) runtime, O(1) space ¨C In-place reverse:
public class Reverseword {
	public static void reverseword(char[]  s) {
		// first reverse the whole string
		reverse(s, 0, s.length - 1);
		// then reverse each work seperately
		int k = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i]== ' ') {
				reverse(s, k, i-1);
				k = i + 1;
			}
			if (i==s.length-1) {
				reverse(s, k, i);
		
			}
		}
	}

	public static void reverse(char[] s, int left, int right) {
         while(left<=right){
        	 char temp=s[left];
        	 s[left]=s[right];
        	 s[right]=temp;
        	 left++;
        	 right--;
         }
		
	}
	
	public static void main (String[] args){
		char[]s="Could you do it".toCharArray();
		reverseword(s);
		for(int i =0;i<s.length;i++){
			System.out.print(s[i]);
		}
		
	}

	/*Rotate an array to the right by
	 *  k steps in-place without allocating extra space. For
	instance, 
	with k = 3, the array [0, 1, 2, 3, 4, 5, 6] 
	is rotated to [4, 5, 6, 0, 1, 2, 3].
 */
}
