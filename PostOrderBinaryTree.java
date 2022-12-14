import java.util.Stack;
import java.util.*;

public class PostOrderBinaryTree {
	
	private TreeNode root;
	
	private class TreeNode{
		private TreeNode right;
		private TreeNode left;
		private int data;
		
		public TreeNode(int data) {
			this.data=data;
		}
	}
	
	public TreeNode createBinaryTreeNode() {
		TreeNode first=new TreeNode(9);
		TreeNode second=new TreeNode(2);
		TreeNode third=new TreeNode(3);
		TreeNode fourth=new TreeNode(4);
		TreeNode fifth=new TreeNode(5);
		
	    root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		second.right=fifth;
		return root;	
	}
	
	public void postOrderRecursive(TreeNode root) {
		if(root==null) {
			return;
		}
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data+" ");
	}
	
	public void postOrderIterative(TreeNode root) {
		TreeNode current=root;
		Stack<TreeNode> stack=new Stack<>();
		while(current!=null || !stack.isEmpty()) {
			if(current!=null) {
				stack.push(current);
				current=current.left;
			}else {
				TreeNode temp=stack.peek().right;
				if(temp==null) {
					temp=stack.pop();
					System.out.print(temp.data+" ");
					while(!stack.isEmpty() && temp==stack.peek().right) {
						temp=stack.pop();
						System.out.print(temp.data+" ");
					}
				}else {
					current=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		PostOrderBinaryTree b=new PostOrderBinaryTree();
		b.createBinaryTreeNode();
		System.out.println("PostOrder using Recursion : ");
		b.postOrderRecursive(b.root);
		System.out.println();
		System.out.println("Postorder using Iteration : ");
		b.postOrderIterative(b.root);
	}

}
