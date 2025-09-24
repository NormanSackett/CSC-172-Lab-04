import java.util.Collection;
import java.util.Iterator;

public class URLinkedList<E> implements URList {

	URNode<E> head = new URNode<E>(null, null, null);
	URNode<E> tail = new URNode<E>(null, null, null);
	
	// initialize an empty linked list
	public URLinkedList() {
		head.setNext(tail);
		tail.setPrev(head);
	}
	
	// initialize a linked list with data from an object array
	public URLinkedList(E[] arr) {
		URNode<E> tempNode = head;
		for (int i = 0; i < arr.length; i++) {
			tempNode.setNext(new URNode<E>(arr[i], tempNode, null));
			tempNode = tempNode.next();
		}
		tempNode.setNext(tail);
		tail.setPrev(tempNode);
	}
	
	// Inserts the specified element at the beginning of this list.
	public void addFirst(E e) {
		URNode<E> n = head.next();
		head.setNext(new URNode<E>(e, head, n));
	}
	
	// Appends the specified element to the end of this list.
	public void addLast(E e) {
		URNode<E> p = tail.prev();
		tail.setPrev(new URNode<E>(e, p, tail));
	}
	
	// Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
	public URNode<E> peekFirst() {
		if (head.next() == tail) return null;
		else return head.next();
	}
	
	// Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
	public URNode<E> peekLast() {
		if (head.next() == tail) return null;
		else return tail.prev();
	}
	
	// Retrieves and removes the first element of this list, or returns null if this list is empty.
	public URNode<E> pollFirst() {
		if (head.next() == tail) return null;
		else {
			URNode<E> n = head.next();
			head.setNext(n.next());
			return n;
		}
	}
	// Retrieves and removes the last element of this list, or returns null if this list is empty.
	public URNode<E> pollLast() {
		if (head.next() == tail) return null;
		else {
			URNode<E> n = tail.prev();
			tail.setPrev(n.prev());
			return n;
		}
	}

	@SuppressWarnings("unchecked") // e is already of type E within the URList interface, so it need not be checked
	@Override
	public boolean add(Object e) {
		URNode<E> p = tail.prev();
		tail.setPrev(new URNode<E>((E) e, p, tail));
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, Object element) {
		URNode<E> e = new URNode<E>((E) element, null, null);
		URNode<E> curNode = head;
		for (int i = 0; i <= index; i++) {
			curNode = curNode.next();
		}
		e.setPrev(curNode);
		curNode = e;
		while (curNode.next() != null) {
			curNode.setNext(curNode.prev().next());
			curNode.prev().setNext(curNode);
			curNode = curNode.next();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean addAll(Collection c) {
		URNode<E> p = tail.prev();
		for (int i = 0; i < c.size(); i++) {
			tail.setPrev(new URNode<E>((E) c.iterator().next(), p, tail));
		}
		return true;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public boolean addAll(int index, Collection c) {
		URNode<E> e = new URNode<E>((E) c.iterator().next(), null, null);
		URNode<E> curNode = head;
		for (int i = 0; i <= index; i++) {
			curNode = curNode.next();
		}
		e.setPrev(curNode);
		curNode = e;
		while (curNode.next() != null) {
			curNode.setNext(curNode.prev().next());
			curNode.prev().setNext(curNode);
			curNode = curNode.next();
		}
		return true;
	}

	@Override
	public void clear() {
		head.setNext(tail);
		tail.setPrev(head);
	}

	@Override
	public boolean contains(Object o) {
		URNode<E> curNode = head.next();
		while(curNode.next() != null) {
			if (curNode.element() == o) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean containsAll(Collection c) {
		URNode<E> curNode = head.next();
		while(curNode.next() != null) {
			if (!c.contains(curNode.element())) return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object o) { // ??????
		return false;
	}

	@Override
	public Object get(int index) {
		URNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next();
		}
		return n.element();
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		URNode<E> curNode = head;
		while (curNode.next() != null) {
			if (curNode.next() == o) return index;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if (head.next() == tail) return true;
		else return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public URList subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
