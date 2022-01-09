package searchandsort;

import java.util.Arrays;

public class SearchingAndSortingAlgo {

	public static boolean LinearSearch(int[] arr, int elementToFind) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i]==elementToFind) {
				return true;
			}
			i+=1;
		}
		return false;
	}
	
	public static void BubbleSort(int[] arr) {
		// Set elementPos to N - 1
		int elementPos = arr.length - 1;

		// while (elementPos > 0) do
		while (elementPos > 0) {
			// Set i to 0
			int i = 0;

			// while ( i < elementPos) do
			while (i < elementPos) {
				// if (arr[i] > arr[i + 1]) then
				if (arr[i] < arr[i + 1]) {
					// Swap i and i+1 elements of arr
					int t = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = t;
				}

				// Increment i by 1
				++i;
			}

			// Decrement elementPos by 1
			--elementPos;
		}
	}
	
	public static void BubbleSortAsc(int[] arr) {
		// Set elementPos to N - 1
				int elementPos = 0;

				// while (elementPos > 0) do
				while (elementPos < arr.length-1) {
					// Set i to 0
					int i = arr.length - 1;

					// while ( i < elementPos) do
					while (i > elementPos) {
						// if (arr[i] > arr[i + 1]) then
						if (arr[i] < arr[i - 1]) {
							// Swap i and i+1 elements of arr
							int t = arr[i];
							arr[i] = arr[i - 1];
							arr[i - 1] = t;
						}

						// Increment i by 1
						--i;
					}

					// Decrement elementPos by 1
					++elementPos;
				}
	}
	
	public static boolean BinarySearch(int[] arr, int elementToFind) {
		BubbleSortAsc(arr);
		
		int leftpos = 0;
		int rightpos = arr.length - 1;
		
		while(leftpos <= rightpos) {
			int middlepos = (leftpos + rightpos)/2;
			
			if(elementToFind == arr[middlepos]) {
				return true;
			}
			
			if(elementToFind < arr[middlepos]) {
				rightpos = middlepos - 1;
			}
			else {
				leftpos = middlepos + 1;
			}
		}
		
		return false;
		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10, 4, 3, 1, 9, 5, 17, 90, 6, 2};

		System.out.println("Unsorted array = " + Arrays.toString((arr)));
		BubbleSortAsc(arr);
		System.out.println("Sorted array   = " + Arrays.toString((arr)));
		System.out.println(LinearSearch(arr, 90));
		System.out.println(BinarySearch(arr, 32));

	}

}
