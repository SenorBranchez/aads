/*
 * AADS - bsp01
 * @author Wolfgang Kremser
 * @author Gregor Bankhamer
 * @author Kevin Kain
 */
public class LinkedList {
	
	protected class Node implements Comparable<Node> {
		
		Node(int val) {
			data = val;
		}
		
		int data = 0;
		Node next = null;
		
		@Override
		public int compareTo(Node o) {
			if(data < o.data) return -1;
			if(data > o.data) return 1;
			return 0;
		}
	}
	
	private Node head = null;
	private Node tail = null;
	
	public int length = 0;
	
	public void insert(Node node) {
		
		if(head == null) {
			head = node;
		}
		
		if(tail != null) {
			tail.next = node;
		}
		
		tail = node;
		length++;
	}
	
	public void insert(int val) {
		
		Node node = new Node(val);
		insert(node);
	}
	
	public Node get(int idx) throws Exception {
		if(idx < 0 || idx >= length) {
			throw new Exception("Delete out of bounds, idx: " + idx + " length: " + length);
		}
		
		Node curr = head;
		
		for(int i = 0; i < idx; i++) {
			curr = curr.next;
		}
		
		return curr;
	}
	
	public Node delete(int idx) throws Exception {
		
		Node ret = null;
		
		if(idx < 0 || idx >= length) {
			throw new Exception("Delete out of bounds, idx: " + idx + " length: " + length);
		}
		
		if(idx == 0) {
			ret = head;
			head = head.next;
		}
		else if(idx == length-1) {
			ret = tail;
			tail = get(length-1);
			tail.next = null;
		}
		else {
			Node prev = head;
						
			for(int i = 0; i < idx - 1; i++) {
				prev = prev.next;
			}
			
			ret = prev.next;
			
			prev.next = prev.next.next;
		}
		
		length--;
		
		return ret;
	}
	
	public Node search(int val) {
		
		Node curr = head;
		
		while(curr != null) {
			if(curr.data == val) {
				return curr;
			}
		}
		
		return null;
	}

	public LinkedList mergeWith(LinkedList l2) {
		LinkedList l1 = this;
		
		LinkedList ret = new LinkedList();
				
		while(l1.length > 0 && l2.length > 0) {

			try {
				switch(l1.get(0).compareTo(l2.get(0))) {
					case -1:
					case 0:
						ret.insert(l1.delete(0));
						break;
					case 1:
						ret.insert(l2.delete(0));
						break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(l1.length > 0) {
			ret.tail.next = l1.head;
		}
		else {
			ret.tail.next = l2.head;
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		
		Node curr = head;
		String ret = "";
		
		while(curr != null) {
			ret += curr.data + " ";
			curr = curr.next;
		}
		return ret;
	}
}
