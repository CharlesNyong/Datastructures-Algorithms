import java.util.Scanner;


public class BinarySearchTree {
	BinarySearchTree Left;
	BinarySearchTree Right;
	int data;
	
	public BinarySearchTree(int val){
		this.data = val;
		
	}
	
	// inserting into a binary search tree
	public void insert(int value){
		if(value < this.data){ // insert as a left child
			// this is the first time we are inserting 
			if(this.Left == null){
				this.Left = new BinarySearchTree(value);
			}else{ // recursively find where to insert the value in the left subtree
				this.Left.insert(value);
			}
		}
		else{
			// this is the first time we are inserting 
			if(this.Right == null){
				this.Right = new BinarySearchTree(value);
			}else{ // recursively find where to insert the value in the Right subtree
				this.Right.insert(value);
			}
		}
	}
	
	// searches for a value in the binary search tree
	public boolean contains(int x){
		if(this.data == x){ // check the root value first
			return true;
		}
		else if(x < this.data){
			if(this.Left == null)
				return false;
			else
				return (this.Left.contains(x));
		}
		else{
			if(this.Right == null)
				return false;
			else
				return (this.Right.contains(x));
		}
	}
	
	/* prints the values of the tree in an orderly manner
	 * Idea: it traverses the left child first, the root and then right child
	 * */
	public void inOrder(){
		if(this.Left != null){
			this.Left.inOrder();
		}
		System.out.print(this.data + " ");
		 
		 if(this.Right != null){
			this.Right.inOrder();
		} 
	}	
	
	/* prints the values of the tree in a preOrdered manner
	 * Idea: it traverses the root first, the left and then right child
	 * */
	public void preOrder(){
		System.out.print(this.data + " "); // print root value first
		
		
		if(this.Left != null){
			this.Left.preOrder();
		}
		
		if(this.Right != null){
			this.Right.preOrder();
		}
	}
	
	
	/* prints the values of the tree in a postOrdered manner
	 * Idea: it traverses the left child first, the right and then root value
	 * */
	public void postOrder(){
		
		if(this.Left != null){
			this.Left.preOrder();
		}
		
		if(this.Right != null){
			this.Right.preOrder();
		}
		
		System.out.print(this.data + " ");
	}
	
	public static void main(String[] args) {
		int MaxNum = 5;
		Scanner reader = new Scanner(System.in);
		boolean firstTime = true;
		BinarySearchTree root = null;
		System.out.println("Enter " + MaxNum + " integers to be inserted into a tree");
		
		for(int i=1; i<=MaxNum; i++){
			int value = reader.nextInt();
			if(firstTime){
				root = new BinarySearchTree(value);
				firstTime = false;
			}
			else{
				root.insert(value);
			}
		}
		
		System.out.println("--- In order traversal ---");
		root.inOrder();
		System.out.println("\n--- Pre order traversal ---");
		root.preOrder();
		System.out.println("\n--- Post order traversal ---");
		root.postOrder();
	}

}
