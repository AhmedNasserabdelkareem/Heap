package eg.edu.alexu.csd.filestructure.sort.cs09;

import eg.edu.alexu.csd.filestructure.sort.INode;

public class Node <T extends Comparable<T>> implements INode <T> {
	private T nodeValue;
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	private int index;

	@Override
	public INode<T> getLeftChild() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public INode<T> getRightChild() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public INode<T> getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return nodeValue;
	}

	@Override
	public void setValue(T value) {
		// TODO Auto-generated method stub
		this.nodeValue = value;
		
	}

	
	public int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	
	public void setIndex(int nodeIndex) {
		// TODO Auto-generated method stub
		this.index = nodeIndex;
		
	}
}
