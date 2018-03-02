package eg.edu.alexu.csd.filestructure.sort.cs09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.text.html.HTMLDocument.Iterator;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;

/**
 * 
 * 
 * getParentIndex ,getRightChildIndex , getLeftChildIndex ,, should be in the node itself
 * it isn't efficient to loop through all the tree at each insertion or even heapify
 		i think we should ignore getParent .. and use getIndex , getParent Index , .. 
 		when we swap or add elements , we will change only the index of the node
 		
 		and if it is necessary to set parent,l&r children nodes , we shall do it in O(c)  
 * finally the flow should be :
 		h.build(list); //that will build the max heap using heapify
 		start loop (collection size) times
 		heapNO2.Insert(h.extract); // remove the max 
 		heapify the root 
 		end loop
 		return heapNo2
 *TODO move getparent&LC&RCIndex to node , if(getparent is important for the tester , change the buildHeap method to run in O(c) )
 * @param <T>
 */
public class MyHeap<T extends Comparable<T>> implements IHeap<T> {
	private ArrayList<Node<T>> tree = new ArrayList<>();
	private int size = 0;
	private final static int ROOT_INDEX = 0;
	private final static int FIRST_INDEX = 1;
	private final static int SECOND_INDEX = 2;
	private final static int NOT_FOUND_ERROR = -1;

	@Override
	public INode<T> getRoot() {
		if (size > ROOT_INDEX)
			return tree.get(ROOT_INDEX);
		return null;
	}

	@Override
	public int size() {
			return size;		
	}

	@Override
	public void heapify(INode<T> node) {
		int nodeIndex = tree.indexOf(node);
		if(node!=null&&nodeIndex!=NOT_FOUND_ERROR) {
			int leftIndex = ((Node<T>) node).getLeftIndex();
			int rightIndex = ((Node<T>) node).getRightIndex();
			int max = ROOT_INDEX;
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
	

	}

	private void swap(int nodeIndex, int max) {
		T temp =tree.get(nodeIndex).getValue();
		tree.get(nodeIndex).setValue(tree.get(max).getValue());
		tree.get(max).setValue(temp);
	}

	@Override
	public T extract() {
		T t =tree.get(0).getValue();
		this.size--;
		swap(0,size);
		tree.set(size, null);
		return t ;
	}

	

	@Override
	public void insert(T element) {
		if (element != null) {
			Node<T> temp = new Node<>();
			temp.setValue(element);
			temp.setIndex(size);
			tree.add( temp);
			//			tree.add(0, temp); if we should return it min heapify
			size++;
			int parentIndex = temp.getParentIndex();
			if (parentIndex >= 0 &&parentIndex< size()) {
				Node<T> Parent = tree.get(parentIndex);

			temp.setParent(tree.get(parentIndex));
			if(Parent.getRightIndex()==size-1){
				Parent.setRightChild(temp);
			}else{
				Parent.setLeftChild(temp);

			}
		}
			

		} else {
			throw new RuntimeException("insert null");
		}

	}
	
	
	@Override
	public void build(Collection<T> unordered) {
		java.util.Iterator<T> it = unordered.iterator();
		tree.clear();
		size=0;
		while(it.hasNext()){
			this.insert(it.next());
		}
		for(int i = size()/2-1;i>=0;i--){
			heapify(tree.get(i));
		}
	}


	public void print() {
		for (int i = 0; i < tree.size(); i++) {
			System.out.print(tree.get(i).getValue() + " ");
		}
		System.out.println();
	}

}
