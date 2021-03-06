import java.util.*;
public class HighestAverageScore {

	public static void main(String[] args) {
		
		String[][] students= {{"Bob","100"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};
		int high=Integer.MIN_VALUE;
		Map<String,Integer> sum = new HashMap<String,Integer>();
		Map<String,Integer> count = new HashMap<String,Integer>();
		
		for(String[] student:students) {
			int avg=0;
			if(count.containsKey(student[0])) {
				
				int currCount=count.get(student[0]);
				currCount++;
				count.put(student[0], currCount);
				
				int currSum=sum.get(student[0]);
				currSum+=Integer.valueOf(student[1]);
				sum.put(student[0], currSum);
				
				avg=currSum/currCount;
			}else {
				count.put(student[0], 1);
				sum.put(student[0], Integer.valueOf(student[1]));
				avg=Integer.valueOf(student[1]);
				
			}
			high=Math.max(high, avg);
		}
		
		System.out.println(high);

	}

}