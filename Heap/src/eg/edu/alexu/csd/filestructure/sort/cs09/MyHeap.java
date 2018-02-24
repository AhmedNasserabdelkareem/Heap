package eg.edu.alexu.csd.filestructure.sort.cs09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;

public class MyHeap <T extends Comparable<T>> implements IHeap<T> {
	private ArrayList<Node<T>> tree = new ArrayList<>();
	private int size=-1;

	@Override
	public INode<T> getRoot() {
		// TODO Auto-generated method stub
		if (size>=0)
			return tree.get(0);
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if (size>=0)
			return size+1;		
		throw null;
	}

	@Override
	public void heapify(INode<T> node) {
		// TODO Auto-generated method stub
		int nodeIndex=((Node<T>) node).getIndex();
		int leftIndex= getLeftIndex(nodeIndex);
		int rightIndex= getRightIndex(nodeIndex);
		int max =0;
		if ((leftIndex<=size)&&(tree.get(leftIndex).getValue().compareTo(node.getValue())>0)) {
			max=leftIndex;
		}else {
			max=((Node<T>) node).getIndex();
		}
		
		if ((rightIndex<=size)&&(tree.get(rightIndex).getValue().compareTo(tree.get(max).getValue())>0)) {
			max=rightIndex;
		}	
		if (max!=nodeIndex) {
	        Collections.swap(tree, nodeIndex, max);
	        heapify(tree.get(max));
		}
		
	}

	@Override
	public T extract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		if (element!= null) {
		Node<T> temp = new Node<>();
		size++;
		temp.setValue(element);
		temp.setIndex(size);
		tree.add(temp);
		}else {
			throw null;
		}
		
		
	}

	@Override
	public void build(Collection<T> unordered) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private int getLeftIndex(int index) {
		return (index*2)+1;
	}
	private int getRightIndex(int index) {
		return (index*2)+2;
		
	}
	private int getParentIndex(int index) {
		return ((index-1)/2);		
	}
	
	public void print() {
		for (int i=0;i<tree.size();i++) {
			System.out.print(tree.get(i).getValue()+" ");
		}
		System.out.println();
	}
	
}
