/* A generic node class used as a 
 * helper data structure to implement other data structures 
 * */

public class Node<T> {

	T data;
	Node<T> next;
	
	public Node(T value){
		this.data = value;
		next = null;
	}
}
