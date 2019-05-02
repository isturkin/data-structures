public class ResizingStack<Element> {

	private Element[] values;
	private int count;

	@SuppressWarnings("unchecked")
	public ResizingStack(int capacity) {
		values = (Element[]) new Object[capacity];
	}

	public void push(Element element) {
		if (isFull()) {
			resize(2 * values.length);
		}
		values[count++] = element;
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

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == values.length;
	}

	public int size() {
		return count;
	}

	@SuppressWarnings("unchecked")
	private void resize(int max) {
		System.out.println("Stack is full. Resizing...");
		Element[] temp = (Element[]) new Object[max];
		for (int i = 0; i < values.length; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}

	public static void main(String[] args) {
		ResizingStack<Integer> stack = new ResizingStack<>(3);

                stack.push(12);
                stack.push(5);
                stack.push(3);

                //try to push 4th element(stack will be resized)
                stack.push(10);
		System.out.println("New stack size is: " + stack.size());

                //pop and print all elements in the stack
                while(!stack.isEmpty()) {
                        System.out.print(stack.pop() + " ");
                }

                System.out.println();
                //try to extract non-existing element(stack underflow)
                stack.pop();	
	}
} 
