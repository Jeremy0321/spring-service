/**
 * 
 */
package com.jeremy.collection;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author jeremy
 *
 */
public class LinkedList<E> extends AbstractCollection<E> implements List<E> {
	
	/**
	 * (first == null && last == null) || (first.prev == null && first.item != null)
	 */
	Node<E> first;
	
	/**
	 * (first == null && last == null) || (last.next == null && last.item != null)
	 */
	Node<E> last;
	
	int size;
	
	

	public LinkedList() {
		super();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new LinkedIter();
	}

	class LinkedIter implements Iterator<E>{
		
		int cursor;
		
		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public E next() {
			int i = cursor;
            E next = get(i);
            cursor = i + 1;
            return next;
		}

		@Override
		public void remove() {
			LinkedList.this.remove(cursor);
			cursor--;
		}
		
	}
	
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<>(l, e, null);
		last = newNode;
		if(l == null){
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		Object[] cs = c.toArray();
		
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		if(!(index >=0 && index<size)){
			throw new IndexOutOfBoundsException();
		}
		Node<E> node = first;
		for(int i=0;i<index;i++){
			node = node.next;
		}
		return node.item;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	static class Node<E> {
		E item;
		Node<E> prev;
		Node<E> next;
		
		Node(Node<E> prev, E item, Node<E> next){
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("aaa");
		list.add("bbbb");
		System.out.println(list.toString());
	}
}
