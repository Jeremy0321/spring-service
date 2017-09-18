/**
 * 
 */
package com.jeremy.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author jeremy
 *
 */
public class ArrayList<E>  extends AbstractList<E> implements List<E> {

	final int DEFAULT_SIZE = 10;
	int size;
	E[] elements;
	
	
	
	
	public ArrayList() {
		super();
		elements = (E[]) new Object[DEFAULT_SIZE];
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
		if(o == null){
			for(int i=0;i<size;i++){
				if(elements[i] == null)
					return true;
			}	
		} else {
			for(int i=0;i<size;i++){
				if(elements[i].equals(o))
					return true;
			}
		}
		
		return false;
	}

	
	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}
	
	 class Iter implements Iterator<E>{

		int cursor;
		
		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public E next() {
			if(cursor >= size){
				throw new IndexOutOfBoundsException("index out of bounds !");
			}
			return (E) elements[cursor++];
		}

		@Override
		public void remove() {
			ArrayList.this.remove(cursor);
		}
		
	}

	@Override
	public Object[] toArray() {
		Object[] objects = new Object[size];
		for(int i=0; i<size;i++){
			objects[i] = elements[i];
		}
		return objects;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		int oldSize = elements.length;
		
		if(oldSize - size <= 0){
			Object[] newElements = new Object[oldSize + oldSize/2];
			for(int i=0;i<size;i++){
				newElements[i] = elements[i];
			}
			newElements[size++] = e;
			elements = (E[]) newElements;
		} else {
			elements[size++] = e;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if(index == -1){
			return false;
		}
		
		this.remove(index);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o:c){
			if(!contains(o)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		int newLength = elements.length + c.size();
		int newSize = size+c.size();
		Object[] newElements = new Object[newLength];
		Object[] oldElements = elements;
		int oldSize = size;
		Object[] cElements = c.toArray();
		for(int i=0;i<newSize;i++){
			if(i< oldSize){
				
				newElements[i] = oldElements[i];
			} else{
				newElements[i] = cElements[i - oldSize];
			}
		}
		elements = (E[])newElements;
		size = newSize;
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		int newLength = elements.length + c.size();
		int newSize = size+c.size();
		Object[] newElements = new Object[newLength];
		Object[] oldElements = elements;
		int oldSize = size;
		Object[] cElements = c.toArray();
		for(int i=0; i<newSize;i++){
			if(i<index){
				newElements[i] = oldElements[i];
			} else if( i< index+c.size()){
				newElements[i] = cElements[i-index];
			} else {
				newElements[i] = oldElements[i-cElements.length];
			}
		}
		size = newSize;
		elements = (E[])newElements;
		return true;
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
		for(int i=0;i<size;i++){
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public E get(int index) {
		if(index >= size){
			throw new IndexOutOfBoundsException("index out of bounds exception!");
		}
		return (E)elements[index];
	}

	@Override
	public E set(int index, E element) {
		if(index >= size){
			throw new IndexOutOfBoundsException("index out of bounds exception!");
		}
		E old = (E)elements[index];
		elements[index] = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		int oldSize = elements.length;
		
		Object[] oldElements = elements;
		Object[] newElements = null;
		if(oldSize - size <= 0){
			newElements = new Object[oldSize + oldSize/2];
		} else {
			newElements = new Object[oldElements.length];
		}
		for(int i=0; i< oldSize+1; i++){
			if(i<index){
				newElements[i] = oldElements[i];
			} else if(i== index){
				newElements[i] = element;
			} else if(i>index){
				newElements[i] = oldElements[i-1];
			}
		}
		elements = (E[]) newElements;
		size++;
	}

	
	@Override
	public E remove(int index) {
		if(index >=size){
			throw new IndexOutOfBoundsException("index out of Bounds !");
		}
		E[] oldElement = elements;
		int oldSize = elements.length;
		
		Object[] newElement = new Object[oldSize]; 
		for(int i = 0; i< size;i++){
			if(i < index){
				newElement[i] = oldElement[i];
			} else {
				newElement[i] = oldElement[i+1];
			}
		}
		size--;
		elements = (E[])newElement;
		return oldElement[index];
	}

	@Override
	public int indexOf(Object o) {
		if(o == null){
			for(int i=0;i<size;i++){
				if(elements[i] == null){
					return i;
				}
			}
		} else {
			for(int i=0;i<size;i++){
				if(elements[i].equals(o)){
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if(o == null){
			for(int i = size-1; i >= 0 ;i--){
				if(elements[i] == null){
					return i;
				}
			}
		} else {
			for(int i = size-1; i >= 0 ;i--){
				if(elements[i].equals(o)){
					return i;
				}
			}	
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListIter(0);
	}

	
	@Override
	public ListIterator<E> listIterator(int index) {
		return new ListIter(index);
	}

	@SuppressWarnings("hiding")
	class ListIter extends Iter implements ListIterator<E>{
		
		ListIter(int index){
			cursor = index;
		}
		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public E previous() {
			return null;
		}

		@Override
		public int nextIndex() {
			return cursor;
		}

		@Override
		public int previousIndex() {
			return cursor - 1;
		}

		@Override
		public void set(E e) {
			ArrayList.this.set(cursor, e);
		}

		@Override
		public void add(E e) {
			ArrayList.this.add(e);
		}
		
	}
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if(fromIndex < 0 || toIndex < 0 || toIndex < fromIndex){
			throw new IllegalArgumentException("argument is illegal !");
		}
		Object[] oldElements = elements;
		Object[] subElements = new Object[toIndex - fromIndex];
		int start =0;
		for(int i=fromIndex;i<toIndex;i++){
			subElements[start++] = oldElements[i];
		}
		return (List<E>) Arrays.asList(subElements);
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<15;i++){
			list.add("hello"+i);
		}
		System.out.println(list);
		ArrayList<String> cList = new ArrayList<>();
		for(int i=0;i<5;i++){
			cList.add("jeremy"+i);
		}
		System.out.println(cList);
		System.out.println(list.addAll(4, cList));
		System.out.println(list);
	}
	

}
