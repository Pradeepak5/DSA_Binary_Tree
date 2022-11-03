import java.util.*;
import java.util.Stack;

public class InOrderBinaryTree {
	
	private TreeNode root;
	
	private class TreeNode{
		private TreeNode left;
		private TreeNode right;
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
	
	public void inOrderRecursive(TreeNode root) {
		if(root==null) {
			return;
		}
		inOrderRecursive(root.left);
		System.out.print(root.data+" ");
		inOrderRecursive(root.right);
	}
	
	public void inOrderIterative(TreeNode root) {
		if(root==null) {
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
		TreeNode temp=root;
		while(!stack.isEmpty()||temp!=null) {
			if(temp!=null) {
				stack.push(temp);
				temp=temp.left;
			}else {
				temp=stack.pop();
				System.out.print(temp.data+" ");
				temp=temp.right;
			}
		}
	}
	

	public static void main(String[] args) {
		InOrderBinaryTree b=new InOrderBinaryTree();
		b.createBinaryTreeNode();
		System.out.println("InOrder using Recursive : ");
		b.inOrderRecursive(b.root);
		System.out.println();
		System.out.println("InOrder using Iteration : ");
		b.inOrderIterative(b.root);

	}

}
