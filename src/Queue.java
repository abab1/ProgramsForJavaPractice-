
public class Queue {

	public Node front;
	
	public int length;
	
	public void printList() {
		Node temp = front;
		if (temp == null) {
			return;
		}
		while ( temp.getNext() != null) {
			System.out.print(temp.value + ",");
			temp = temp.getNext();
		}
		System.out.println(temp.value);
	}
	
	public void add(int value) {
		Node node = new Node(value, null);
		if (this.front == null) {
			this.front = node; 
			length++;
		} else {
			Node temp = front;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.next = node;
			length++;
		}
	}
	
	public Node get(int value){
		Node temp = front;
		while (temp.getNext().value != value) {
			temp = temp.getNext();
		}
		return temp.getNext();
	}
	
	public void remove(int value) {
		Node temp = front;
		if (temp.value == value) {
			front = temp.getNext();
			length--;
		} else {
			while (temp.getNext().value != value) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			length--;
		}
		
	}

	public Node getStart() {
		return front;
	}

	public void setStart(Node start) {
		this.front = start;
	}
	
	@Override
	public String toString() {
		return "LinkedList [start=" + front + ", length=" + length + "]";
	}
}
