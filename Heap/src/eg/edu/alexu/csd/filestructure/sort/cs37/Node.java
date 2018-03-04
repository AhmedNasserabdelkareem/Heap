package eg.edu.alexu.csd.filestructure.sort.cs37;

import eg.edu.alexu.csd.filestructure.sort.INode;

/**
 * @author ahmednasser
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements INode<T> {
	private T nodeValue;
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	private int index;

	@Override
	public INode<T> getLeftChild() {
		return left;
	}

	@Override
	public INode<T> getRightChild() {
		return right;
	}

	@Override
	public INode<T> getParent() {
		return parent;
	}

	@Override
	public T getValue() {
		return nodeValue;
	}

	@Override
	public void setValue(T value) {
		this.nodeValue = value;

	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int nodeIndex) {
		this.index = nodeIndex;

	}

	public void setLeftChild(Node<T> left) {
		this.left = left;
	}

	public void setRightChild(Node<T> right) {
		this.right = right;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	

	public int getLeftIndex() {
		return (index * 2) + 1;
	}

	public int getRightIndex() {
		return (index * 2) + 2;

	}

	public int getParentIndex() {
		if ((index-1)<0) {
			return -1;
		}
		return ((index - 1) / 2);
	}
}
