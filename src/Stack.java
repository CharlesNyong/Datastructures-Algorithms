
public class Stack <T> {
	
	linkedList<T> stack;
	
	public Stack(T value){
		stack = new linkedList<T>(value);
	}
	
	/*returns the items in the head of the list
	 * without removing it
	 * */
	public T peek(){
		// stack is empty
		if(stack.head == null){
			return null;
		}
		
		return (stack.head).data;
		
		//return value;
	}
	
	public T pop(){
		// stack is empty
		if(stack.isEmpty()){
			return null;
		}
		
		T data = (stack.head).data;
		
		if(stack.deleteHead())
			return data; // if successfully deleted
		else
			return null;  // if not deleted
	}
	
	public void push(T data){
		if(stack.isEmpty()){
			stack = new linkedList<T>(data);
		}
		else{
			stack.addToFront(data);
		}
	}
	
	public void printStack(){
		stack.displayItems();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> myStack = new Stack<Character>('A');
		myStack.push('B');
		myStack.push('C');
		myStack.push('D');
		myStack.push('E');
		myStack.push('F');

		
		// display items in stack
		myStack.printStack();
	}

}
