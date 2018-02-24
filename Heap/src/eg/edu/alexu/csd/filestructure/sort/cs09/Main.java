package eg.edu.alexu.csd.filestructure.sort.cs09;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHeap x = new MyHeap<>();
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
		Node cd = new Node<>();
		cd.setValue(4);
		x.heapify(cd);
		x.print();

		

	}

}
