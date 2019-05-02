public class StackWithFixedSize<Element> {

	private Element[] values;
	private int count;
	
	@SuppressWarnings("unchecked")
	public StackWithFixedSize(int capacity) {
		values = (Element[]) new Object[capacity];
	}

	public void push(Element newValue) {
		values[count++] = newValue;
	}

	public Element pop() {
		return values[--count];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public static void main(String[] args) {
		StackWithFixedSize<Integer> stack = new StackWithFixedSize<>(10);
		stack.push(12);
		stack.push(5);
		stack.push(3);

		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}			
}
