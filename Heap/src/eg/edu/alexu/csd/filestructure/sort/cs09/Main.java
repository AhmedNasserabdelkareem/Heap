package eg.edu.alexu.csd.filestructure.sort.cs09;

import java.util.ArrayList;

import eg.edu.alexu.csd.filestructure.sort.IHeap;

public class Main {

	public static void main(String[] args) {
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		al.add(5);
//		al.add(7);
//		al.add(9);
//		al.add(2);
//		al.add(3);
//		al.add(10);
//		al.add(1);
//		al.add(14);
//MySort<Integer> s  =new MySort<Integer>();
//MyHeap<Integer> h =(MyHeap<Integer>)s.heapSort(al);
//h.print();
		MyHeap<Integer> x = new MyHeap<>();
		System.out.println();
		x.insert(16);
		x.insert(4);
		x.insert(10);
		x.insert(14);
		x.insert(7);
		x.insert(9);
		x.insert(3);
		x.insert(2);
		x.insert(8);
		x.insert(1);
		x.print();
		System.out.println(x.size());

	//	x.heapify(cd);
		ArrayList<Integer> unordered = new ArrayList<>();
		unordered.add(16);
		unordered.add(4);
		unordered.add(10);
		unordered.add(14);
		unordered.add(7);
		unordered.add(9);
		unordered.add(3);
		unordered.add(2);
		unordered.add(8);
		unordered.add(1);
		x.build(unordered);
		x.print();

		

	}

}
