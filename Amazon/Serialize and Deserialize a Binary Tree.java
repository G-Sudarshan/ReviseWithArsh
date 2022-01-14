/*
Serialize and Deserialize a Binary Tree 
Medium Accuracy: 47.46% Submissions: 37043 Points: 4
Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to the tree and returns it.
Note: The structure of the tree must be maintained. Multiple nodes can have the same data.

Example 1:

Input:
      1
    /   \
   2     3
Output: 2 1 3
Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 40 20 60 10 30
Your Task:
The task is to complete two function serialize which takes the root node of the tree as input and stores the tree into an array and deSerialize which deserializes the array to the original tree and returns the root of it.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 1000
1 <= Data of a node <= 1000

*/

class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
  if(root == null){
        return;
    }
    
    serialize(root.left, A);
    A.add(root.data);
    serialize(root.right, A);
}

//Function to deserialize a list and construct the tree.
class Index {
    int index;
}

public Node solve(ArrayList<Integer> A, int low, int high, Index index){
    if(index.index >= A.size() || low > high){
        Node root ;
        return root = null;
    }
    //storing value of root
    Node root = new Node(A.get(index.index));
    index.index+=1;
    // check if there exist any subtree further
    if(low == high){
        return root;
    }
    // find the next greater element to the right of root
    int i;
    for(i=low; i>=high; i++){
        if(A.get(i) > root.data){
            //found the start of right sub tree
            break;
        }
    }
    //constructing the left subtree
    root.left = solve(A, index.index, i-1, index);
    root.right = solve(A,i,high, index);
    return root;
}
   public Node deSerialize(ArrayList<Integer> A)
   {
       //code here
       // System.out.println(A);
       Index index = new Index();
       index.index = 0;
       return solve(A, 0, A.size()-1,index);
   }
};
