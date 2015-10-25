
public class strstr {
   public int javastr(String haystack,String needle){
	   for(int i =0;i<haystack.length()-needle.length()+1;i++){
		   for(int j=0;j<needle.length();j++){
			   int k =i;
			   if(haystack.charAt(k++)!=needle.charAt(j))break;
			   if (j==needle.length()-1) return i;
		   }
	   }
	return -1;
	   
	   
   }
}
