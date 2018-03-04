package eg.edu.alexu.csd.filestructure.sort.cs37;

import java.util.ArrayList;

import eg.edu.alexu.csd.filestructure.sort.IHeap;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(6);
		al.add(3);
		al.add(5);
		al.add(7);
		al.add(1);
		al.add(4);
		al.add(2);
		
//MySort<Integer> s  =new MySort<Integer>();
//MyHeap<Integer> h =(MyHeap<Integer>)s.heapSort(al);
//h.print();
		MyHeap<Integer> x = new MyHeap<>();
		x.build(al);
		//x.print();
		for(int i = al.size();i>0;i--)
		System.out.println(x.extract());
//		System.out.println();
//		x.insert(16);
//		x.insert(4);
//		x.insert(10);
//		x.insert(14);
//		x.insert(7);
//		x.insert(9);
//		x.insert(3);
//		x.insert(2);
//		x.insert(8);
//		x.insert(1);
//		x.print();
//		System.out.println(x.size());

	//	x.heapify(cd);
//		ArrayList<Integer> unordered = new ArrayList<>();
//		unordered.add(16);
//		unordered.add(4);
//		unordered.add(10);
//		unordered.add(14);
//		unordered.add(7);
//		unordered.add(9);
//		unordered.add(3);
//		unordered.add(2);
//		unordered.add(8);
//		unordered.add(1);
//		x.build(unordered);
//		x.print();
//
//		

	}

}
