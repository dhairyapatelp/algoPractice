import java.util.*;

class HighestAverage{
	public static void main(String[] args){
		String[][] stu = {{"Bob","87"}, {"Mike", "45"},{"Bob", "52"}, {"Jason","45"}, {"Mike", "55"}, {"Jessica", "99"}};
		findHighestAverage(stu);
	}
//  {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};
	public static void findHighestAverage(String[][] stu){
		Map<String, Integer> sMap = new HashMap<>();
		Map<String, Integer> cMap = new HashMap<>();
		
		Map<String, Integer> mapAvg =  new HashMap<>();

		for(String[] eachStu: stu){
			String student = eachStu[0];
			int mark = Integer.parseInt(eachStu[1]);
			if(!sMap.containsKey(student)){
				sMap.put(student, mark);
				cMap.put(student, 1);
			}
			else{
				sMap.put(student, sMap.get(student)+mark);
				cMap.put(student, cMap.get(student)+1);
			}
		}

		for(String each: sMap.keySet()){
			mapAvg.put(each, sMap.get(each).intValue()/cMap.get(each).intValue());
		}

		PriorityQueue<String>  pq = new PriorityQueue<>(
															(a,b) ->  
															mapAvg.get(a).equals(mapAvg.get(b)) ? 
															a.compareTo(b) : 
															mapAvg.get(a)-mapAvg.get(b)
														);
		for(String each: mapAvg.keySet()){
			pq.offer(each);
			while(pq.size()>1) pq.poll();
		}

		while(!pq.isEmpty()){
			String val = pq.poll();
			System.out.println(val);
			System.out.println(sMap.get(val));
			System.out.println("-----");
		}
		
	}
}