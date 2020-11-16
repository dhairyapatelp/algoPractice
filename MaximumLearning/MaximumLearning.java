import java.lang.Math;
import java.util.*;

public class MaximumLearning{
	static int fin = Integer.MIN_VALUE;
	public static void main(String[] args){
		List<Integer> iv = new ArrayList<Integer>();
		iv.add(1);
		iv.add(4);
		iv.add(2);
		iv.add(5);
		iv.add(3);

		List<Integer> article = new ArrayList<Integer>();
		article.add(2);
		article.add(6);
		article.add(4);
		article.add(7);
		article.add(1);

		System.out.println(maximumLearning(iv, article, 13));

	}

	// public static int maximumLearning(List<Integer> iv, List<Integer> articles, int p){
	// 	helper(iv, articles, p, 0, 0);
	// 	System.out.println(fin);
	// 	return 0;
	// }

	// private static void helper(List<Integer> iv, List<Integer> articles, int target, int ans, int index){
	// 	if(target<0) return;
	// 	else{
	// 		for(int i=index; i<articles.size() && articles.get(i)<=target; i++){
	// 			ans += (iv.get(i));
	// 			helper(iv, articles, target-(articles.get(i)*2), ans, i+1);
	// 			ans -= (iv.get(i));
	// 		}
	// 		fin = Math.max(fin, ans);
	// 	} 
	// }

	public static int maximumLearning(List<Integer> iv, List<Integer> articles, int p){
        int n = articles.size();
        int i, w;
        int K[][] = new int[n + 1][p + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i<= n; i++) {
            for (w = 0; w<= p; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if ((articles.get(i - 1) * 2) <= w)
                    K[i][w] = max(iv.get(i - 1) + K[i - 1][w - articles.get(i - 1) * 2], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][p];
    }

    static int max(int a, int b){ 
    	return (a > b) ? a : b; 
    }
	// public static int maximumLearning(List<Integer> iv, List<Integer> articles, int p)
	// {

 //    	int max = 0;
 //    	float[] ivPerPage = new float[iv.size()];
 //    	for(int i=0;i<iv.size();i++)
 //        	ivPerPage[i] = articles.get(i)/iv.get(i);

 //    	for(int i=0;i< iv.size()-1;i++)
 //    	{
 //        	for(int j=i+1;j<iv.size();j++)
 //        	{
 //            	if(ivPerPage[i]<ivPerPage[j])
 //            	{
 //                	float temp = ivPerPage[i];
 //                	ivPerPage[i] = ivPerPage[j];
 //                	ivPerPage[j] = temp;
                  
 //                	int tempInt = iv.get(i);
 //                	iv.set(i,iv.get(j));
 //                	iv.set(j, tempInt);
                  
 //                	tempInt = articles.get(i);
 //                	articles.set(i, articles.get(j));
 //                	articles.set(j, tempInt);
 //            	}
 //        	}
 //    	}
 //    	for(int i=0;i<iv.size() && p>0;i++)
 //    	{
 //        	if(2*articles.get(i) <= p)
 //        	{
 //            	p -= 2*articles.get(i);
 //            	max += iv.get(i);
 //        	}
 //    	}

 //    	return max;
	// }

}
