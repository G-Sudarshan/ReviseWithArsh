/*
Burning Tree 
Hard Accuracy: 44.86% Submissions: 8077 Points: 8
Given a binary tree and a node called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.


Example 1:

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 
8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
Example 2:

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    / 
 8    10
Target Node = 10
Output: 5

Your Task:  
You don't need to read input or print anything. Complete the function minTime() which takes the root of the tree and target as input parameters and returns the minimum time required to burn the complete binary tree if the target is set on fire at the 0th second.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ N ≤ 104


*/

class Solution {
  public:
    int minTime(Node* root, int target) 
    {
        // Your code goes here
        unordered_map<Node*, Node*> parent;

        //find target
        queue<Node*> q1;
        q1.push(root);

        Node* node;

        while(!q1.empty()) {
            node = q1.front();
            q1.pop();
            
            if(node->data == target) {
                break;
            }

            if(node->left != NULL) {
                parent[node->left] = node;
                q1.push(node->left);
            }

            if(node->right != NULL) {
                parent[node->right] = node;
                q1.push(node->right);
            }
        }

        // find largest dist
        queue<Node*> q2;
        q2.push(node);
        q2.push(NULL);

        unordered_map<Node*, bool> queued;
        int dist = -1;

        while(!q2.empty()) {

            node = q2.front();
            q2.pop();

            if(node == NULL) {
                ++dist;
                if(!q2.empty()) {
                    q2.push(NULL);
                }
                continue;
            }

            if(node->left != NULL && !queued.count(node->left)) {
                q2.push(node->left);
                queued[node->left] = true;
            }

            if(node->right != NULL && !queued.count(node->right)) {
                q2.push(node->right);
                queued[node->right] = true;
            }

            if(parent.count(node) && !queued.count(parent[node])) {
                q2.push(parent[node]);
                queued[parent[node]] = true;
            }
        }

        return dist;
    }
};
