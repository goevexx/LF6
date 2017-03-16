package Sort;

public class Sortieralgorithmen {
	final static boolean ASC = true;
	final static boolean DESC = false;

	public static void bubbleSort(IntArray randomSortArray, boolean direction) {
		randomSortArray.setStartSortTime(System.nanoTime());
		int[] sortArray = randomSortArray.getIntArray();
		int n = randomSortArray.getMaxIndex();
		if (direction == ASC) {
			do {
				int newn = 1;
				for (int i = 0; i < n; ++i) {
					if (sortArray[i] > sortArray[i + 1]) {
						swap(sortArray, i, i + 1);
						newn = i + 1;
					}
				}
				n = newn;
			} while (n > 1);
		} else if (direction == DESC) {
			do {
				int newn = 1;
				for (int i = 0; i < n; ++i) {
					if (sortArray[i] < sortArray[i + 1]) {
						swap(sortArray, i, i + 1);
						newn = i + 1;
					}
				}
				n = newn;
			} while (n > 1);
		}
		randomSortArray.setEndSortTime(System.nanoTime());
		// return randomSortArray;
	}

	private static int[] swap(int[] swapArray, int pos1, int pos2) {
		int cache = swapArray[pos1];
		swapArray[pos1] = swapArray[pos2];
		swapArray[pos2] = cache;
		return swapArray;
	}

	public static void quickSort(IntArray intArray, boolean direction) {
		intArray.setStartSortTime(System.nanoTime());
		qSort(intArray.getIntArray(), 0, intArray.getMaxIndex(),direction);
		intArray.setEndSortTime(System.nanoTime());
	}

	private static void qSort(int x[], int links, int rechts, boolean direction) {
		if (links < rechts) {
			int i = partition(x, links, rechts,direction);
			qSort(x, links, i - 1,direction);
			qSort(x, i + 1, rechts,direction);
		}
	}

	private static int partition(int x[], int links, int rechts,
			boolean direction) {
		int pivot, i, j, help;
		pivot = x[rechts];
		i = links;
		j = rechts - 1;
		while (i <= j) {
			if (direction)
				if (x[i] > pivot) {
					swap(x, i, j);
					j--;
				} else
					i++;
			else {
				if (x[i] < pivot) {
					swap(x, i, j);
					j--;
				} else
					i++;
			}
		}
		// tausche x[i] und x[rechts]
		help = x[i];
		x[i] = x[rechts];
		x[rechts] = help;

		return i;
	}

	public static void insertionSort(IntArray intArray, boolean direction) {
		intArray.setStartSortTime(System.nanoTime());
		int[] sortArray = intArray.getIntArray();
		int j;
		int sortValue;
		for (int i = 1; i <= intArray.getMaxIndex(); i++) {
			sortValue = sortArray[i];
			j = i;
			if (direction == ASC)
				while ((j > 0) && (sortArray[j - 1] > sortValue)) {
					sortArray[j] = sortArray[j - 1];
					j--;
				}
			else if (direction == DESC)
				while ((j > 0) && (sortArray[j - 1] < sortValue)) {
					sortArray[j] = sortArray[j - 1];
					j--;
				}
			sortArray[j] = sortValue;
		}
		intArray.setIntArray(sortArray);
		intArray.setEndSortTime(System.nanoTime());
		// return intArray;
	}

	public static void selectionSort(IntArray sortIntArray, boolean direction) {
		sortIntArray.setStartSortTime(System.nanoTime());
		int[] sortArray = sortIntArray.getIntArray();
		if (direction == ASC)
			for (int i = 0; i <= sortIntArray.getMaxIndex() - 1; i++) {
				for (int j = i + 1; j <= sortIntArray.getMaxIndex(); j++) {
					if (sortArray[i] > sortArray[j]) {
						int temp = sortArray[i];
						sortArray[i] = sortArray[j];
						sortArray[j] = temp;
					}
				}
			}
		else if (direction == DESC)
			for (int i = 0; i <= sortIntArray.getMaxIndex() - 1; i++) {
				for (int j = i + 1; j <= sortIntArray.getMaxIndex(); j++) {
					if (sortArray[i] < sortArray[j]) {
						int temp = sortArray[i];
						sortArray[i] = sortArray[j];
						sortArray[j] = temp;
					}
				}
			}
		sortIntArray.setIntArray(sortArray);
		// return sortIntArray;
	}
}
