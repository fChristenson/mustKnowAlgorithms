import java.util.Arrays;

public class MustKnowAlgorithms {
	private static int[] numbers = { 3, 2, 1, -2, 8, 7, -6 };
	private static final int VAL = 8;
	private static final String MSG = "Index of number is: ";

	public static void main(String[] args) {

		System.out.println("Unsorted list: " + Arrays.toString(numbers));
		mergeSort(numbers);
		System.out.println("Sorted list: " + Arrays.toString(numbers));

		int result = recursiveBinarySearch(numbers, VAL, 0, numbers.length - 1);
		System.out.println(MSG + result);

		result = iterativeBinarySearch(numbers, VAL);
		System.out.println(MSG + result);
	}

	public static int iterativeBinarySearch(int[] array, int val) {
		int mid = 0, low = 0, high = array.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;
			if (array[mid] == val)
				return mid;

			else if (array[mid] > val)
				high = mid - 1;

			else
				low = mid + 1;
		}
		return -1;
	}

	public static int recursiveBinarySearch(int[] array, int val, int low,
			int high) {
		int mid = (low + high) / 2;
		if (array[mid] == val)
			return mid;

		else if (low >= high || array.length < 1)
			return -1;

		else if (array[mid] > val)
			return recursiveBinarySearch(array, val, low, mid - 1);

		else
			return recursiveBinarySearch(array, val, mid + 1, high);

	}

	public static void mergeSort(int[] array) {

		if (array.length > 1) {
			int mid = array.length / 2;

			int[] left = Arrays.copyOfRange(array, 0, mid);
			int[] right = Arrays.copyOfRange(array, mid, array.length);

			mergeSort(left);
			mergeSort(right);

			merge(array, left, right);
		}
	}

	public static void merge(int[] result, int[] left, int[] right) {

		int i = 0, j = 0, k = 0;

		while (i < result.length) {
			if (j < left.length && k < right.length) {
				if (left[j] <= right[k]) {
					result[i] = left[j];
					j++;

				} else {
					result[i] = right[k];
					k++;
				}

			} else if (j >= left.length) {
				while (k < right.length) {
					result[i] = right[k];
					k++;
					i++;
				}

			} else {
				while (j < left.length) {
					result[i] = left[j];
					j++;
					i++;
				}
			}
			i++;
		}
	}
}