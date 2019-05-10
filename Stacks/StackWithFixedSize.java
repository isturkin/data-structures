public class StackWithFixedSize<Element> {

	private Element[] values;
	private int count;
	
	@SuppressWarnings("unchecked")
	public StackWithFixedSize(int capacity) {
		values = (Element[]) new Object[capacity];
	}

	public void push(Element newValue) {
		if (!isFull()) {
			values[count++] = newValue;
		} else {
			System.out.printf("%s", "Stack overflow!\n");
		}
	}

	public Element pop() {
		if (!isEmpty()) {
			Element element = values[--count];
			values[count] = null;
			return element;
		} else {
			System.out.printf("%s", "Stack underflow!\n");
			return null;
		}
	}

	public Element peek() {
		if (!isEmpty()) {
			int top = count - 1;
			return values[top];
		} else {
			System.out.printf("%s", "Stack underflow!\n");
			return null;
		}
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == values.length;
	}

	public int size() {
		return count;
	}

	public static void main(String[] args) {
		StackWithFixedSize<Integer> stack = new StackWithFixedSize<>(3);

		stack.push(12);
		stack.push(5);
		stack.push(3);

		//check peek() method
		System.out.println("Peek an element on the top: " + stack.peek());
		
		//try to push 4th element(stack overflow)
		stack.push(10);
		
		//pop and print all elements in the stack
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
		System.out.println();
		//try to extract non-existing element(stack underflow)
		stack.pop();
	}			
}
