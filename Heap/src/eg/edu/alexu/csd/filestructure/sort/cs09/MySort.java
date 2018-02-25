package eg.edu.alexu.csd.filestructure.sort.cs09;

import java.util.ArrayList;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.ISort;

public class MySort<T extends Comparable<T>> implements ISort<T> {

	@Override
	public IHeap<T> heapSort(ArrayList<T> unordered) {
		MyHeap<T> h = new MyHeap<>();
		h.build(unordered);
		MyHeap<T> h2 = new MyHeap<>();
		h2.build(unordered);
		for(int i = unordered.size()-1;i>0;i--){
			unordered.set(i,h.extract());
			h.heapify(h.getRoot());
		}		
		return h2;
	}

	@Override
	public void sortSlow(ArrayList<T> unordered) {
		int i, j;
		int n = unordered.size();
		for (i = 0; i < n - 1; i++) {
			for (j = 0; j < n - i - 1; j++) {
				if (unordered.get(j).compareTo(unordered.get(j + 1)) > 0) {
					T temp = unordered.get(j);
					unordered.set(j, unordered.get(j + 1));
					unordered.set(j + 1, temp);
				}
			}
		}
	}

	void merge(ArrayList<T> arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		ArrayList<T> L = new ArrayList<>();
		ArrayList<T> R = new ArrayList<>();

		for (int i = 0; i < n1; ++i)
			L.add(arr.get(l + i));
		for (int j = 0; j < n2; ++j)
			R.add(arr.get(m + 1 + j));

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L.get(i).compareTo(R.get(j)) <= 0) {
				arr.set(k, L.get(i));
				i++;
			} else {
				arr.set(k, R.get(j));
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr.set(k, L.get(i));
			i++;
			k++;
		}

		while (j < n2) {
			arr.set(k, R.get(j));
			j++;
			k++;
		}
	}

	void sort(ArrayList<T> arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	@Override
	public void sortFast(ArrayList<T> unordered) {
		sort(unordered, 0, unordered.size() - 1);
	}
}
