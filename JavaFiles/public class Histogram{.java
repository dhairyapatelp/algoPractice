import java.util.*;

public class Histogram{
	public static void main(String[] args){
		int[] area = {2,1,5,6,2,3};

		Histogram ar = new Histogram();
		System.out.println("Max Area is: "+ar.calculateHistogramArea(area));
	}

	public int calculateHistogramArea(int[] arr){
		int maxArea = Integer.MINVALUE;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int len = arr.length;

		while(i<arr.length){
			if(stack.isEmpty() || arr[stack.peek()]<=arr[i]){
				stack.push(i++);
			}else{
				int curr = stack.pop();
				int val = stack.isEmpty() ? i : i-1-stack.peek();
				int area = arr[curr] * val;
				maxArea = Math.max(maxArea, area);
			}
		}

		while(!stack.isEmpty()){
			int curr = stack.pop();
			int val = stack.isEmpty() ? i : i-1-stack.peek();
			int area = arr[curr] * val;
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}
}