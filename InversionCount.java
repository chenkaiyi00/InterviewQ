import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionCount {

	public static void main(String[] args) throws IOException {

		File file = new File("1.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		int[] nums = new int[100000];
		int count = 0;
		// Read File Line By Line
		while ((line = bufferedReader.readLine()) != null) {
			int a = Integer.parseInt(line);
			nums[count++] = a;
		}

		// Close the input stream
		fileReader.close();
		int []temp = new int [100000];
		int answer = inversioncount(0,count-1,nums,temp);
		System.out.println(answer);
	}

	public static int inversioncount(int start, int end, int[] nums,int[] temp) {
		int  inv_count = 0;
		if (end > start){
		int mid = (end - start) / 2 + start;
		int leftinversion = inversioncount(start, mid, nums,temp);
		int rightinversion = inversioncount(mid+1, end, nums,temp);
		int inversion = sortcount(start, end, mid+1, nums, temp);
		 inv_count=leftinversion + rightinversion + inversion;
		}
		return inv_count;
	}

	private static int sortcount(int start, int end,int mid, int[] nums,int[] temp) {
		 int i, j, k;
		  int inv_count = 0;
		  i = start; 
		  j = mid; 
		  k = start; 
		  while ((i <= mid - 1) && (j <= end))
		  {
		    if (nums[i] <= nums[j])
		    {
		      temp[k++] = nums[i++];
		    }
		    else
		    {
		      temp[k++] = nums[j++];
		      inv_count = inv_count + (mid - i);
		    }
		  }
		  while (i <= mid - 1)
			    temp[k++] = nums[i++];
		  while (j <= end)
			    temp[k++] = nums[j++];
		  for (i=start; i <= end; i++)
			    nums[i] = temp[i];
		return inv_count;
	}
}
