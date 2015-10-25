
public class Palindrome {

	public  static boolean valid(String string){
		int left =0;
		int right=string.length()-1;
		while(left<right){
			while(left<right&&!Character.isLetterOrDigit(string.charAt(left))) left++;
			while(left<right&&!Character.isLetterOrDigit(string.charAt(right))) right--;
			if(string.charAt(right)!=string.charAt(left))return false;
			else{
				left++;
				right--;
			}
		}
		return true;
	}
}
