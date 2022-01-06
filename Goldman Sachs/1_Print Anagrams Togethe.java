/*
Print Anagrams Together 
Medium Accuracy: 56.1% Submissions: 24547 Points: 4
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.


Example 1:

Input:
N = 5
words[] = {act,god,cat,dog,tac}
Output:
act cat tac 
god dog
Explanation:
There are 2 groups of
anagrams "god", "dog" make group 1.
"act", "cat", "tac" make group 2.
Example 2:

Input:
N = 3
words[] = {no,on,is}
Output: 
no on
is
Explanation:
There are 2 groups of
anagrams "no", "on" make group 1.
"is" makes group 2. 

Your Task:
The task is to complete the function Anagrams() that takes a list of strings as input and returns a list of groups such that each group consists of all the strings that are anagrams.


Expected Time Complexity: O(N*|S|*log|S|), where |S| is the length of the strings.
Expected Auxiliary Space: O(N*|S|), where |S| is the length of the strings.


Constraints:
1<=N<=100

View Bookmarked Problems
Company Tags
Topic Tags
Related Courses
Related Interview Experiences
*/

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
        
        for(String str: string_list){
            HashMap<Character, Integer> fmap = new HashMap<>();
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
            }
            
            if(bmap.containsKey(fmap) == false){
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                bmap.put(fmap, al);
            }else{
                ArrayList<String> al = bmap.get(fmap);
                al.add(str);
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        for(ArrayList<String> val: bmap.values() ){
            res.add(val);
        }
        
        return res;
        
        
    }
}
