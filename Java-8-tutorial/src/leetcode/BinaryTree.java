package leetcode;

public class BinaryTree {
	
	
	Node<Integer> root = null;
	
	
	
	public boolean find(Integer x) {
		
		Node<Integer> curr = root;
		
		while(curr != null) {
			if(x.compareTo(curr.value) < 0) {
				//consider the left node
				curr = curr.left;
			} else if(x.compareTo(curr.value) > 0) {
				//consider the right node
				curr = curr.right;
			} else {
				//object found return true
				return true;
			}
		}
		
		return false;
	}
	
	public boolean insert(Integer x) {
		Node<Integer> curr = root;
		boolean isAdded = false;
		
		while(curr != null) {
			if(x.compareTo(curr.value) < 0) {
				//consider the left node
				if(curr.left == null) {
					curr.left = new Node<Integer>(x);
					isAdded = true;
					break;
				}			
				curr = curr.left;
			} else if(x.compareTo(curr.value) > 0) {
				//consider the right node
				if(curr.right == null) {
					curr.right = new Node<Integer>(x);
					isAdded = true;
					break;
				}
				curr = curr.right;
			} else {
				//value already present
				break;
			}
		}
		
		return isAdded;
	}
	
	
	
	
	
	class Node<E>{
		E value;
		Node right;
		Node left;
		
		public Node(E value) {
			super();
			this.value = value;
			this.right = null;
			this.left = null;
		}

		
		
	}

}
