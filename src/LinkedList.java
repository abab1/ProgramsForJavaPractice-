
public class LinkedList {

	public Node start;
	
	public int length;
	
	public void printList() {
		Node temp = start;
		if (temp == null) {
			return;
		}
		while ( temp.getNext() != null) {
			System.out.print(temp.value + ",");
			temp = temp.getNext();
		}
		System.out.println(temp.value);
	}
	
	public void addAtIndex(int value, int index) {
		int count = 0;
		Node temp = start;
		if (temp == null) {
			return;
		}
		while ( temp.getNext() != null) {
			if (count == index-1) {
				Node n = new Node(value, temp.getNext().getNext());
				temp.setNext(n);
				return;
			} else {
				temp = temp.getNext();
				count++;
			}
		}
	}
	
	public void add(int value) {
		Node node = new Node(value, null);
		if (this.start == null) {
			this.start = node; 
			length++;
		} else {
			Node temp = start;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.next = node;
			length++;
		}
	}
	
	public Node get(int value){
		Node temp = start;
		while (temp.getNext().value != value) {
			temp = temp.getNext();
		}
		return temp.getNext();
	}
	
	public void remove(int value) {
		Node temp = start;
		if (temp.value == value) {
			start = temp.getNext();
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
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(34);
		list.add(24);
		list.add(48);
		list.add(1);
		list.add(67);
		list.add(36);
		list.printList();
		list.addAtIndex(56, 2);
		list.printList();
		list.remove(24);
		list.printList();
		list.remove(67);
		list.printList();
		list.remove(34);
		list.printList();
		list.remove(56);
		list.printList();
		list.remove(36);
		list.printList();
		list.remove(1);
		list.printList();
	}
	
	@Override
	public String toString() {
		return "LinkedList [start=" + start + ", length=" + length + "]";
	}

	
}
