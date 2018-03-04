package eg.edu.alexu.csd.filestructure.sort.cs37;

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
		heapifyAll();

		try{
		if(size>0){
		T t =tree.get(0).getValue();
		swap(0,size-1);
		tree.remove(size-1);
		this.size--;

	if(size>0){
	heapify(tree.get(0));
	
		}
		return t ;
		}else{
			throw new RuntimeException("can't extract empty heap");
		}
		}catch(Exception e){
			throw new RuntimeException("extract -size"+size);
		}
	}

	

	@Override
	public void insert(T element) {
		try{
		if (element != null) {
			Node<T> temp = new Node<T>();
			temp.setValue(element);
			temp.setIndex(size);
			tree.add( temp);
			size++;
			int parentIndex = temp.getParentIndex();
			if (parentIndex >= 0 &&parentIndex< size()) {
				Node<T> Parent = tree.get(parentIndex);

			temp.setParent(tree.get(parentIndex));
			if(Parent.getRightIndex()==size-1){
				Parent.setRightChild(temp);
			}else if(Parent.getLeftIndex()==size-1){
				Parent.setLeftChild(temp);
			}else{
				throw new RuntimeException("unexpected behaviour in insert");
			}
			heapifyAll();
		}
			

		} else {
			throw new RuntimeException("insert null");
		}
		}catch(Exception e){
			throw new RuntimeException("insert -size"+size);
		}

	}
	
	
	private void heapifyAll() {
		for(int i =size()/2-1;i>=0;i--){
			heapify(tree.get(i));
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
			throw new RuntimeException("build -size"+size);
		}
	}


	public void print() {
		for (int i = 0; i < tree.size(); i++) {
			System.out.print(tree.get(i).getValue() + " ");
		}
	}

}
