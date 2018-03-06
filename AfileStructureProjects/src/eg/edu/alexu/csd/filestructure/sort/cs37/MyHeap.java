package eg.edu.alexu.csd.filestructure.sort.cs37;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.text.html.HTMLDocument.Iterator;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;


public class MyHeap<T extends Comparable<T>> implements IHeap<T> {
	private ArrayList<Node<T>> tree = new ArrayList<>();
	private int size = 0;
	
	@Override
	public INode<T> getRoot() {
		if (size > 0){
			return tree.get(0);
		}
		return null;
	}

	@Override
	public int size() {
			return size;		
	}

	@Override
	public void heapify(INode<T> node) {
		try{
		int nodeIndex = tree.indexOf(node);
		if(node!=null&&nodeIndex!=-1) {
			int leftIndex = ((Node<T>) node).getLeftIndex();
			int rightIndex = ((Node<T>) node).getRightIndex();
			int max = 0;
			if ((leftIndex < size) && (tree.get(leftIndex).getValue().compareTo(node.getValue()) > 0)) {
				max = leftIndex;
			} else {
				max = ((Node<T>) node).getIndex();
			}

			if ((rightIndex < size) && (tree.get(rightIndex).getValue().compareTo(tree.get(max).getValue()) > 0)) {
				max = rightIndex;
			}
			if (max != nodeIndex) {
				swap( nodeIndex, max);
				heapify(tree.get(max));
			}
		}
		}catch(Exception e){
			throw new RuntimeException("heapify -size"+size);
		}

	}

	private void swap(int nodeIndex, int max) {
		try{
		T temp =tree.get(nodeIndex).getValue();
		tree.get(nodeIndex).setValue(tree.get(max).getValue());
		tree.get(max).setValue(temp);
		}catch(Exception e){
			throw new RuntimeException("swaap -node i "+nodeIndex+"max"+max+"size"+size);
		}
	}

	@Override
	public T extract() {
		

		
		if(size>0){
		T t =tree.get(0).getValue();
		swap(0,size-1);
		int pIndex=tree.get(size-1).getParentIndex();
		if(pIndex>=0){
		Node<T>parent =tree.get(pIndex);
		if(parent.getLeftIndex()==size-1){
			parent.setLeftChild(null);
		}else{
			parent.setRightChild(null);
		}
		}
		tree.remove(size-1);
		this.size--;
	heapifyAll();
		return t ;
		}
		return null;
		
	}

	

	@Override
	public void insert(T element) {
		if (element != null) {
			Node<T> temp = new Node<T>();
			temp.setValue(element);
			temp.setIndex(size);
			tree.add( temp);
			size++;
			int parentIndex = temp.getParentIndex();
			
			if (parentIndex >= 0 &&parentIndex< size()) {
				Node<T> Parent = tree.get(parentIndex);
			temp.setParent(Parent);
			if(Parent.getRightIndex()==temp.getIndex()){
				Parent.setRightChild(temp);
			}else if(Parent.getLeftIndex()==temp.getIndex()){
				Parent.setLeftChild(temp);
			}
			heapifyAll();
		}
			

		}

	}
	
	public void insertWithoutHeapify(T element) {
		if (element != null) {
			Node<T> temp = new Node<T>();
			temp.setValue(element);
			temp.setIndex(size);
			tree.add( temp);
			size++;
			int parentIndex = temp.getParentIndex();
			
			if (parentIndex >= 0 &&parentIndex< size()) {
				Node<T> Parent = tree.get(parentIndex);
			temp.setParent(Parent);
			if(Parent.getRightIndex()==temp.getIndex()){
				Parent.setRightChild(temp);
			}else if(Parent.getLeftIndex()==temp.getIndex()){
				Parent.setLeftChild(temp);
			}
		//	heapifyAll();
		}
			

		}

	}
	
	private void heapifyAll() {
		for(int i =size()/2-1;i>=0;i--){
			heapify(tree.get(i));
		}
		for(int i=0;i<size();i++){
			try{
		}catch(Exception e){
			
		}
		}
	}

	@Override
	public void build(Collection<T> unordered) {
		try{
		java.util.Iterator<T> it = unordered.iterator();
		tree.clear();
		size=0;
		while(it.hasNext()){
			this.insert(it.next());
		}
		heapifyAll();
		}catch(Exception e){
			throw e;
		}
	}


	public void print() {
		for (int i = 0; i < tree.size(); i++) {
			System.out.print(tree.get(i).getValue() + " ");
		}
	}

}
