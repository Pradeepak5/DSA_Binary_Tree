import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderBinaryTree {
	
	private TreeNode root;
	
	private class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		public TreeNode(int data) {
			this.data=data;
		}
	}
	
	public TreeNode createBinaryTree() {
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
	
	public void levelOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp=queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				queue.offer(temp.left);
			}
			if(temp.right!=null) {
				queue.offer(temp.right);
			}
		}
		
	}
	
	public static void main(String args[]) {
		LevelOrderBinaryTree b=new LevelOrderBinaryTree();
		b.createBinaryTree();
		System.out.println("Level Order Traversal of Binary Tree : ");
		b.levelOrderTraversal(b.root);
		
	}

}
