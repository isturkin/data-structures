public class LinkedList<Element> {

	private Node<Element> first;
	private Node<Element> last;

	public LinkedList(Element data) {
		Node<Element> newNode = new Node<>(data, null, null);
		this.first = newNode;
		this.last = newNode;
	}

	public LinkedList() {}

	public void addFirst(Element element) {
		Node<Element> oldFirst = first;
		Node<Element> newNode = new Node<>(element, null, oldFirst);
		first = newNode;
		if (oldFirst == null) {
			last = newNode;
		} else {
			oldFirst.prev = first;
		}
	}

	public Element removeFirst() {
		Element element = null;
		if (first == null) {
			System.out.printf("%s", "List is empty!");
		} else {
			element = first.data;
			Node<Element> next = first.next;
			first = next;
			if (first == null) {
				last = null;
			} else {
				first.prev = null;
			}
		}
		return element;
	}

	public void addLast(Element element) {
		Node<Element> oldLast = last;
		Node<Element> newNode = new Node<>(element, oldLast, null);
		last = newNode;
		if (oldLast == null) {
			first = newNode;
		} else {
			oldLast.next = newNode;
		}		
	}

	public Element removeLast() {
		Element element = null;
		if (last == null) {
			System.out.printf("%s", "List is empty!");
		} else {
			element = last.data;
			Node<Element> prev = last.prev;
			last = prev;
			if (last == null) {
				first = null;
			} else {
				last.next = null;
			}
		}
		return element;
	}
				

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node current = first; current != null; current = current.next) {
			sb.append(current.data + " --> ");
		}
		sb.append("null");
		return sb.toString();
	}

	private static class Node<Element> {
		
		Element data;
		Node<Element> prev;
		Node<Element> next;

		Node(Element data, Node<Element> prev, Node<Element> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		list.addFirst("Java");
		list.addFirst("C");
		list.addFirst("Python");
		System.out.println(list);
		
		list.removeFirst();
		System.out.println(list);

		list.addLast("Go");
		System.out.println(list);

		list.removeLast();
		System.out.println(list);
	}		
}
