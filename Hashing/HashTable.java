package DSA;

class HashTable {
	int size;
	String[] my_hash;

	public HashTable(int size) {
		this.size = size;
		this.my_hash = new String[size];
	}

	public int hashFunction(String value) {
		int sumOfChar = 0;
		for (char c : value.toCharArray()) {
			sumOfChar += (int) c;
		}
		return sumOfChar % size;
	}

	public boolean contains(String value) {
		int index = hashFunction(value);
		if (my_hash[index] == null)
			return false;
		if (my_hash[index].equals(value))
			return true;
		return false;
	}

	public void add(String value) {
		int index = hashFunction(value);
		while (my_hash[index] != null) {
			if (my_hash[index].equals(value))
				return;
			index = (index + 1) % size;
		}
		my_hash[index] = value;

	}

	public boolean delete(String value) {
		int index = hashFunction(value);
		if (my_hash[index] == null)
			return false;
		if (my_hash[index].equals(value)) {
			my_hash[index] = null;
			return true;
		}
		int startIndex = index;
		index = (index + 1) % size;
		while (my_hash[index] != null && index != startIndex) {
			if (my_hash[index].equals(value)) {
				my_hash[index] = null;
				return true;
			}
			index = (index + 1) % size;
		}
		return false;
	}

	public void display() {
		System.out.print("[");
		for (int i = 0; i < size; i++) {
			if (my_hash[i] != null) {
				System.out.print("\"" + "[" + my_hash[i] + "]" + "\"");
			} else {
				System.out.print("null");
			}
			if (i < size - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		HashTable ht = new HashTable(10);
		String[] myArray = { "Peter", "Bob", "Alex", "Messi", "Rose" };
		System.out.println("Danh sach ban dau");
		ht.display();
		System.out.println("Danh sach sau khi them");
		for (String name : myArray) {
			ht.add(name);
		}
		ht.display();
		String element_remove = "Bob";
		System.out.println("Danh sach xoa 1 phan tu " + element_remove + " trong hashtable");
		ht.delete(element_remove);
		ht.display();
		String element_check = "Messi";
		boolean re = ht.contains(element_check);
		System.out.print("Kiem tra phan tu " + element_check + " co trong hashtable khong  " + re);
	}

}
