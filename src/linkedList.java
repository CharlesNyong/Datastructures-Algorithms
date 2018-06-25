
public class linkedList<T> {
	Node<T> head;
	T data;
	
	public linkedList(T value){
		head = new Node<T>(value);
		head.next = null;
	}
	
	// adds data at the beginning of a linkedList
	public void addToFront(T data){
		Node<T> newNode = new Node<T>(data);
		newNode.next = this.head;
		this.head = newNode;
	}	
	
	// adds data to the end of the list
	public void addToList(T data){
		Node<T> current = this.head;
		Node<T> newNode = new Node<T>(data);
		
		if(this.head == null){ // list is empty
			head = newNode;
			head.next = null;
		}
		else{
			// add the new node at the end of the link list
			while(current.next != null){
				current = current.next;
			}
			current.next = newNode;
		}	
	}
	
	public boolean isEmpty(){
		if(this.head == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	// deletes from the head of the list
	public boolean deleteHead(){
		if(this.isEmpty()){ // list is empty
			return false;
		}
		this.head = this.head.next;
		return true;
	}
	
	// deletes from the end of the list
	public boolean delete(){
		if(this.head == null){ // list is empty
			return false;
		}
		Node<T> current = this.head;
		Node<T> prev = null;
		
		while(current.next != null){
			prev = current;
			current = current.next;
		}
		prev.next = null;
		return true;
		
	}
	
	public void displayItems(){
		Node<T> current = this.head;
		
		while(current != null){
			System.out.print(current.data + " =>> ");
			current = current.next;
		}
		System.out.print("null");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedList<Character> myList = new linkedList<Character>('a');
		myList.addToList('b');
		myList.addToList('c');
		myList.addToList('d');
		myList.addToFront('e');
		//myList.deleteHead();
		myList.displayItems();
	}

}
