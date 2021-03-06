//Task 4 lc 1448 https://leetcode.com/problems/count-good-nodes-in-binary-tree/

/*
======
Task 1
Find the bug(s) and modify one line code.
找一个array里面的最小值, 只要改初始值就可以了, 注意这里只能改一行.initialization的时候赋值不应该是0, should be Integer.MAX_VALUE

======
Task 2
Write a function solution that, given an array A of N integers [-100, 100], returns the sign (-1, 0, 1) 
of all numbers in the array multiple together.
Assuming that N is between 1 and 1000.

For example, given A = [1,-2,-3,5], the function should return 1
Given A = [1,2,3,-5], your function should return -1
Given A = [1,2,0,-5], your functin should return 0


class Solution {
    
    int neg = 0;
    for (int i : A) {
        if (i < 0) neg++;
        if (i == 0) return 0;
    }

    if (neg % 2 == 0) return 1;
    else return -1;
}


======
Task 3 选择题一共10题
1. You are given 5 integers and your task is to find the smallest of them. 
What is the minimum number of comparisons that you have to make? B
a. 3
b. 4
c. 5
d. 6

2. you are given an array with 10^8 elements and you must compute the sum A[j] + A[k] 
for every possible pair of elements in the array, How long will this computation take 
on a single mainstream computer? D
a. milliseconds
b. seconds
c. minutes
d. hours
e. more than few hours

3. How do you check whether a number is odd in most programming languages?  B
a. if (x)
b. if (x & 1)
c. if ( x % 2 == 0)
d. if (x >> 1 == 0)

4. Given a sorted array, which of the following operations can be performed the fastest?  A
a. checking whether the number 42 is in the array
b. counting the number of different elements
c. computing the sum of all elements
d. all of the above operations are linear time, so they are approximately the same

5. A common data structure used to implement a relational database is a    D
a. queue
b. stack
c. priority-queue
d. B-tree

6. Given a list of 1000 elements, which of the following number is the largest C
a. the number of all possible subsets of a given list
b. the number of all possible pairs of elements from a given list
c. the number of all possible permutations of a given list
d. 10,000,000,000,000,000

7. Given a tree with 4 nodes, how many edges have to be added for it to cease being a tree? A
a. 1
b. 2
c. 3
d. 4

8. which of the following statement is correct B
def f(A):
    for i := 0; i < A.length-1; i++  do:
        if (A[i] > A[i+1]):
            swap A[i] with A[i+1]

    return A

a. there is an element that can be removed so that f(A_without_one_element) returns a sorted array
b. for any array of size N, f(A)[N-1] = max(A)
c. for any array of size N, f(A)[0] = min(A)
d. more than one is correct

9. Wich of the following algorithm finds the shortest path in any unweighted graph?  B
a. DFS
b. BFS
c. both
d. neither

10. the time complexity of g(n, x, y) is O(n), what is the time complexity of f(n)  C
def f(n):
    if n == 1:
        return 1
    x = f(n/2)
    y = f(n/2)
    return g(n, x, y)

a. O(logn)
b. O(n)
c. O(nlog(n))
d. O(n^2)

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public int goodNodes(TreeNode root) {
        
        /*
        DFS, each node need to compare with a maximum number in the path
        **/
        if (root == null) return 0;
        
        helper(root, root.val);
        
        return res;
    }
    
    private void helper(TreeNode root, int max) {
        if (root == null) return;
        
        if (root.val >= max) {
            res++;
        }        
        helper(root.left, Math.max(max, root.val));
        helper(root.right, Math.max(max, root.val));
        
    }
}