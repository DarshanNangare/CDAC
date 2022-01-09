package hashing;

import java.util.Arrays;

public class HashTable {
	DList[] hashTable;
	int size;

	public HashTable(int n) {
		size = n;
		// Create array of references to DLL, each set to null.
		hashTable = new DList[size];
	}

	private int hashFunctionModN(int key) {
		return key % size;
	}

	public void Add(int key) {
		int dllId = hashFunctionModN(key);

		if (hashTable[dllId] == null) {
			// DLL is empty. Create a new DLL object.
			hashTable[dllId] = new DList();
			hashTable[dllId].AddAtFront(key);
			return;
		}
		
		System.out.println("Collision: Key = " + key + " dllId = " + dllId);
		hashTable[dllId].isCollision = true;
		hashTable[dllId].AddAtFront(key);
	}

	public boolean Search(int key) {
		int dllId = hashFunctionModN(key);

		if (hashTable[dllId] == null) {
			// DLL empty => Key not found.
			return false;
		}
		
		

		// DLL exists, check if it has the key.
		if (hashTable[dllId].Search(key)) {
			// Found
			System.out.println("Key = " + key + " found in dllId = " + dllId);
			return true;
		}
		
		return false;
	}
	
	public void display(int dllId) {
		if(hashTable[dllId].isCollision) {
			System.out.println(Arrays.toString(hashTable[dllId].getElements()));
		}
	}
}
