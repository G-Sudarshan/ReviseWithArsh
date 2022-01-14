/*
Phone directory 
Hard Accuracy: 40.06% Submissions: 4396 Points: 8
Given a list of contacts contact[] of length n where each contact is a string which exist in a phone directory and a query string s. The task is to implement a search query for the phone directory. Run a search query for each prefix p of the query string s (i.e. from  index 1 to |s|) that prints all the distinct contacts which have the same prefix as p in lexicographical increasing order. Please refer the explanation part for better understanding.
Note: If there is no match between query and contacts, print "0".

Example 1:

Input: 
n = 3
contact[] = {"geeikistest", "geeksforgeeks", 
"geeksfortest"}
s = "geeips"
Output:
geeikistest geeksforgeeks geeksfortest
geeikistest geeksforgeeks geeksfortest
geeikistest geeksforgeeks geeksfortest
geeikistest
0
0
Explaination: By running the search query on 
contact list for "g" we get: "geeikistest", 
"geeksforgeeks" and "geeksfortest".
By running the search query on contact list 
for "ge" we get: "geeikistest" "geeksforgeeks"
and "geeksfortest".
By running the search query on contact list 
for "gee" we get: "geeikistest" "geeksforgeeks"
and "geeksfortest".
By running the search query on contact list 
for "geei" we get: "geeikistest".
No results found for "geeip", so print "0". 
No results found for "geeips", so print "0".
Your Task:
Youd do not need to read input or print anything. Your task is to complete the function displayContacts() which takes n, contact[ ] and s as input parameters and returns a list of list of strings for required prefixes. If some prefix has no matching contact return "0" on that list.

Expected Time Complexity: O(|s| * n * max|contact[i]|)
Expected Auxiliary Space: O(n * max|contact[i]|)
*/

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String str)
    {
        // code here
         HashSet<String> set = new HashSet<>();
       for (String ele : contact) {
           set.add(ele);
       }
       contact = new String[set.size()];
       int j = 0;
       for (String ele : set) {
           contact[j++] = ele;
       }
       Arrays.sort(contact);
       ArrayList<ArrayList<String>> result = new ArrayList<>();
       for (int i = 0; i < str.length(); i++) {
           result.add(new ArrayList<>());
       }
       
       for (String cont : contact) {
           for (int i = 0; i < cont.length(); i++) {
               if (i < str.length() && str.charAt(i) == cont.charAt(i)) {
                   result.get(i).add(cont);
               } else {
                   break;
               }
           }
       }
       
       for (int i = 0; i < str.length(); i++) {
           if (result.get(i).size() == 0) {
               result.get(i).add("0");
           }
       }
       
       return result;
    }
}
