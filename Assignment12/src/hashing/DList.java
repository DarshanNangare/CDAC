package hashing;


public class DList {
	DListNode head;
	DListNode tail;
	boolean isCollision;

	public DList() {
		head = null;
		tail = null;
		isCollision = false;
	}
	
	public void AddAtFront(int element) {
		DListNode newNode;
		newNode = new DListNode(element);

		//newNode.data = element;
		//newNode.next = null;

		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		newNode.next = head;
		head.previous = newNode;
		head = newNode;
	}
	
	public void Delete(int element) {
		DListNode current = head;
		
		while(current != null) {
			if(current.data==element) {
				break;
			}
			current = current.next;
		}
		
		if(current==null) {
			System.out.println("No element found !");
			return;
		}
		
		if(current==head) {
			if(current.next==null) {
				head = null;
				tail = null;
				return;
			}
			current.next.previous = current.previous;
			head = current.next;
			return;
		}
		
		current.previous.next = current.next;
		if(current.next!=null) {
		current.next.previous = current.previous;
		}
	}
	
	public boolean Search(int element) {
		DListNode current = head;
		
		while(current != null) {
			if(current.data==element) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public int getCount() {
		int count = 0;
		DListNode current;

		current = head;
		while (current != null) {
			++count;
			current = current.next;
		}

		return count;
	}

	public int[] getElements() {
		int elements[] = new int[getCount()];
		int i = 0;
		DListNode current;

		current = head;
		while (current != null) {
			elements[i] = current.data;
			++i;
			current = current.next;
		}
		return elements;
	}

	public int[] getElementsInReverse() {
		int elements[] = new int[getCount()];
		int i = 0;
		DListNode current;

		current = tail;
		while (current != null) {
			elements[i] = current.data;
			++i;
			current = current.previous;
		}
		return elements;
	}
}
